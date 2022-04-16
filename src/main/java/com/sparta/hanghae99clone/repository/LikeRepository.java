package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Like;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    boolean existsByPostAndUser(Post post, User user);

    Optional<Like> findByPostAndUser(Post post, User user);
}
