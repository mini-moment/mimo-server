package com.mimo.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mimo.server.dto.HashTagDto;
import com.mimo.server.dto.PostDto;
import com.mimo.server.dto.UserDto;
import com.mimo.server.service.HashTagService;
import com.mimo.server.service.PostService;
import com.mimo.server.service.UserService;
import com.mimo.server.util.ApiUtil;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@ControllerAdvice
@RequestMapping("post/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final HashTagService hashTagService;

    @PostMapping("insert")
    @Operation(summary = "포스트를 작성합니다.")
    public ApiUtil.ApiSuccessResult<Boolean> insertPost(@RequestBody PostDto post, HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        UserDto user = userService.getUserByAccessToken(authorizationHeader);
        int markerId = post.getMarkerId();
        if (markerId == 0) {
            markerId = 1;
        }
        PostDto dto = new PostDto(post.getId(),
                post.getTitle(),
                user.getId(),
                post.getVideoUrl(),
                markerId,
                post.getTagList()
        );
        int postId = postService.insertPost(dto).getId();
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
    public ApiUtil.ApiSuccessResult<List<PostDto>> getPosts(@RequestParam int[] ids){
    	try {
            List<PostDto> posts = postService.getPostsByIds(ids);
            return ApiUtil.success(posts);
        } catch (Exception e) {
            throw e;
        }
    }
}
