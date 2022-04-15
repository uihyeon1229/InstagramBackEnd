package com.sparta.hanghae99clone.service;

import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import com.sparta.hanghae99clone.repository.ImageRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ImageRepository imageRepository;
    private final PostRepository postRepository;

    public void save(PostRequestDto postRequestDto, String uploadImageUrl) {
    }
}
