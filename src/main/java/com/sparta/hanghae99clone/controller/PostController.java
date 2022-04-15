package com.sparta.hanghae99clone.controller;

import com.sparta.hanghae99clone.config.S3Uploader;
import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import com.sparta.hanghae99clone.dto.response.PostResponseDto;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.UserRepository;
import com.sparta.hanghae99clone.service.PostService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final S3Uploader s3Uploader;
    private final PostService postService;
    private final UserRepository userRepository;

    // 단일 게시물 저장
    @PostMapping("/api/posts")
    public String save(
        @RequestParam("images") MultipartFile multipartFile,
        @RequestParam("contents") String content) throws IOException {
        // 테스트 user
        User user = userRepository.findById(1L).get();
        // 이미지 업로드
        String uploadImageUrl = s3Uploader.upload(multipartFile);
        // 게시물 저장
        postService.save(content, uploadImageUrl, user);
        return uploadImageUrl;
    }

    // 모든 게시물 조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> findAll() {
        return postService.findAll();
    }
}