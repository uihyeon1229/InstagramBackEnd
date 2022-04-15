package com.sparta.hanghae99clone.service;

import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import com.sparta.hanghae99clone.dto.response.PostListResponseDto;
import com.sparta.hanghae99clone.dto.response.PostResponseDto;
import com.sparta.hanghae99clone.model.Comment;
import com.sparta.hanghae99clone.model.Image;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.CommentRepository;
import com.sparta.hanghae99clone.repository.ImageRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ImageRepository imageRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

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

    public List<PostListResponseDto> findAll() {
        List<Post> allPost = postRepository.findAll();
        List<PostListResponseDto> postResponseDtos = new ArrayList<>();

        for (Post post : allPost) {
            // 게시글에 해당하는 이미지 불러오기
            Image image = imageRepository.findByPost(post).orElseThrow(
                () -> new IllegalArgumentException("이미지가 존재하지 않습니다.")
            );

            int commentCnt = commentRepository.findByPost(post).size();

            long dayBefore = ChronoUnit.MINUTES.between(post.getCreatedAt(), LocalDateTime.now());
            postResponseDtos.add(new PostListResponseDto(post, image, calculateTime(dayBefore), commentCnt));
        }
        return postResponseDtos;
    }

    private static String calculateTime(long time) {
        if (time < 60) {
            return String.format("%s분 전", time);
        }
        time = time / 60;  // 시간
        if (time < 24) {
            return String.format("%s시간 전", time);
        }
        time = time / 24;
        if (time < 7) {
            return String.format("%s일 전", time);
        }

        time = time / 30;
        if (time < 12) {
            return String.format("%s개월 전", time);
        }

        time = time / 12;
        return String.format("%s년 전", time);
    }
}
