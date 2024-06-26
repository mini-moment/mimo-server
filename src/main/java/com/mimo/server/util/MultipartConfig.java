package com.mimo.server.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import jakarta.servlet.MultipartConfigElement;


@Configuration
public class MultipartConfig {
	
	@Value("${path.videoStoragePath}")
	private String videoStoragePath;

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(videoStoragePath);
        factory.setMaxRequestSize(DataSize.ofMegabytes(100L *  20));
        factory.setMaxFileSize(DataSize.ofMegabytes(100L * 20));

        return factory.createMultipartConfig();
    }
}