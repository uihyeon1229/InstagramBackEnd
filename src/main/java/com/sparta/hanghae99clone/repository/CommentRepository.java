package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Comment;
import com.sparta.hanghae99clone.model.Post;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);
    Page<Comment> findAllByPost(Post post, Pageable pageable);
    List<Comment> deleteByIdAndNickname(Long commentId, String nickname);
    List<Comment> findAllByPost(Post post);
}
