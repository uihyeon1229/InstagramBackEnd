package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Comment;
import com.sparta.hanghae99clone.model.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Post> findByPost(Post post);
    List<Comment> deleteByIdAndNickname(Long commentId, String nickname);
    List<Comment> findAllByPost(Post post);
}
