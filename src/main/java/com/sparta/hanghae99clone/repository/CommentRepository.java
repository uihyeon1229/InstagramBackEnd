package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Comment;
import com.sparta.hanghae99clone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);
    List<Comment> deleteByIdAndNickname(Long commentId, String nickname);
    List<Comment> findAllByPost(Post post);
}
