package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Favorite;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<Favorite> findByPostIdAndUserId(Long postId, Long id);

    boolean existsByPostAndUser(Post post, User user);
}
