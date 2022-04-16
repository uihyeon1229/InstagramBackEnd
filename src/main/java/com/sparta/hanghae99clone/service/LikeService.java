package com.sparta.hanghae99clone.service;


import com.sparta.hanghae99clone.model.Like;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.LikeRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    public void addOrDelLike(Long postId, User user) {
        Post post = postRepository.findById(postId).orElseThrow(
            () -> new IllegalArgumentException("게시물이 존재하지 않습니다. (좋아요)")
        );
        // 사용자가 게시글에 좋아요를 눌렀는지 확인
        Optional<Like> optionalLike = likeRepository.findByPostAndUser(post, user);
        // 좋아요를 누른 상태일 경우
        if (optionalLike.isPresent()) {
            // 좋아요를 해지
            likeRepository.delete(optionalLike.get());
            return;
        }
        // 좋아요를 누르지 않은 상태일 경우
        Like like = new Like(post, user);
        likeRepository.save(like);
    }
}
