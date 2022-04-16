package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<Favorite> findByPostIdAndUserId(Long postId, Long id);

}
