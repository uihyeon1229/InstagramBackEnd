package com.sparta.hanghae99clone.controller;

import com.sparta.hanghae99clone.config.S3Uploader;
import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import com.sparta.hanghae99clone.dto.response.PostListResponseDto;
import com.sparta.hanghae99clone.dto.response.PostResponseDto;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.UserRepository;
import com.sparta.hanghae99clone.security.UserDetailsImpl;
import com.sparta.hanghae99clone.service.PostService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final S3Uploader s3Uploader;
    private final PostService postService;

    // 단일 게시물 저장
    @PostMapping("/api/posts")
    public String save(
        @RequestParam("images") MultipartFile multipartFile,
        @RequestParam("contents") String content,
        @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        // 테스트 user
        User user = userDetails.getUser();
        // 이미지 업로드
        String uploadImageUrl = s3Uploader.upload(multipartFile);
        // 게시물 저장
        postService.save(content, uploadImageUrl, user);
        return uploadImageUrl;
    }

    // 모든 게시물 조회
    @GetMapping("/api/posts")
    public List<PostListResponseDto> findAll(@RequestParam("page") Integer pageid,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 테스트 user

        User user = userDetails.getUser();
        pageid=pageid-1;
        return postService.findAll(user,pageid);
    }

    // 특정 게시글 수정
    @PutMapping("/api/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto) {
        postService.edit(postId, postRequestDto);
    }

    // 특정 게시글 삭제
    @DeleteMapping("/api/posts/{postId}")
    public void remove(@PathVariable Long postId) {
        postService.remove(postId);
    }
}