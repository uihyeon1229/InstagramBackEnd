package com.sparta.hanghae99clone.service;

import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import com.sparta.hanghae99clone.model.Image;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.ImageRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ImageRepository imageRepository;
    private final PostRepository postRepository;

    public void save(PostRequestDto postRequestDto,
        String uploadImageUrl,
        User user) {

        // 게시글 저장
        Post post = new Post(user, postRequestDto);
        postRepository.save(post);

        // 이미지 저장
        Image image = new Image(uploadImageUrl, post);
        imageRepository.save(image);
    }
}
