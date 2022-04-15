package com.sparta.hanghae99clone.service;

import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import com.sparta.hanghae99clone.dto.response.PostResponseDto;
import com.sparta.hanghae99clone.model.Image;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.ImageRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ImageRepository imageRepository;
    private final PostRepository postRepository;

    public void save(String content,
        String uploadImageUrl,
        User user) {

        // 게시글 저장
        Post post = new Post(user, content);
        postRepository.save(post);

        // 이미지 저장
        Image image = new Image(uploadImageUrl, post);
        imageRepository.save(image);
    }

    public List<PostResponseDto> findAll() {
        List<Post> allPost = postRepository.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for (Post post : allPost) {
            postResponseDtos.add(new PostResponseDto(post));
        }
        return postResponseDtos;
    }
}
