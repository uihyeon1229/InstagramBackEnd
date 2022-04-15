package com.sparta.hanghae99clone.controller;

import com.sparta.hanghae99clone.config.S3Uploader;
import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import com.sparta.hanghae99clone.security.UserDetailsImpl;
import com.sparta.hanghae99clone.service.PostService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final S3Uploader s3Uploader;
    private final PostService postService;

    @PostMapping("/images")
    public String upload(@RequestBody PostRequestDto postRequestDto,
        @RequestParam("images") MultipartFile multipartFile,
        @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {

        String uploadImageUrl = s3Uploader.upload(multipartFile);
        postService.save(postRequestDto, uploadImageUrl, userDetails.getUser());
        return uploadImageUrl;
    }
}