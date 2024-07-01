package com.mimo.server.controller;

import com.mimo.server.dto.*;
import com.mimo.server.service.HashTagService;
import com.mimo.server.service.MapService;
import com.mimo.server.service.PostService;
import com.mimo.server.service.UserService;
import com.mimo.server.util.ApiUtil;
import com.mimo.server.util.TimeUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@Slf4j
@ControllerAdvice
@RequestMapping("post/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final HashTagService hashTagService;
    private final MapService mapService;

    @PostMapping("insert")
    @Operation(summary = "포스트를 작성합니다.")
    public ApiUtil.ApiSuccessResult<Boolean> insertPost(
            @RequestPart("post") PostDto post,
            @RequestPart("thumbnail") MultipartFile thumbnail,
            @RequestPart("latitude") Double latitude,
            @RequestPart("longitude") Double longitude,
            HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        UserDto user = userService.getUserByAccessToken(authorizationHeader);
        String thumbnailUrl = postService.saveThumbnail(thumbnail);
        PostDto dto = new PostDto(post.getId(),
                post.getTitle(),
                user.getId(),
                post.getVideoUrl(),
                post.getTagList(),
                thumbnailUrl,
                post.getUploadTime()
        );
        int postId = postService.insertPost(dto).getId();
        mapService.insertMarker(new MarkerDto(0, postId, latitude, longitude));
        List<HashTagDto> hashTagList = dto.getTagList().stream()
                .map(tagDto -> {
                    HashTagDto hashTagDto = new HashTagDto(
                            postId,
                            tagDto.getId()
                    );
                    return hashTagDto;
                }).toList();
        hashTagService.insertHashTagList(hashTagList);
        return ApiUtil.success(true);
    }

    @GetMapping("posts")
    @Operation(summary = "전달받은 Post ID 리스트에 대한 Post 리스트를 반환합니다.")
    public ApiUtil.ApiSuccessResult<List<ResponsePostListDto>> getPosts(@RequestParam int[] ids) {

        List<ResponsePostListDto> postList = postService.getPostsByIds(ids);
        postList.forEach(dto -> {
            dto.setUploadTime(TimeUtil.calculateTimeDifference(dto.getUploadTime()));
        });
        return ApiUtil.success(postList);
    }

    @GetMapping("thumbnail/{url}")
    @Operation(summary = "경로에 해당하는 Post의 썸네일을 반환합니다.")
    public ResponseEntity<Resource> getThumbnail(@PathVariable String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (url.contains("png")) {
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "image/png");
        } else if (url.contains("jpeg")) {
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "image/jpeg");
        }
        return new ResponseEntity<>(postService.getThumbnail(url), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("posts/my")
    @Operation(summary = "해당 유저의 Post List를 받아옵니다")
    public ApiUtil.ApiSuccessResult<List<ResponsePostListDto>> getPostsByAccessToken(@RequestHeader("Authorization") String accessToken) {
        int[] postIds = postService.getPostsIdsByAccessToken(accessToken);
        List<ResponsePostListDto> postList = postService.getPostsByIds(postIds);
        postList.forEach(dto -> {
            dto.setUploadTime(TimeUtil.calculateTimeDifference(dto.getUploadTime()));
        });
        return ApiUtil.success(postList);
    }

}
