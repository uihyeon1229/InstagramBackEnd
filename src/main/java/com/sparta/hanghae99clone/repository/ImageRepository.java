package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Image;
import com.sparta.hanghae99clone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByPost(Post post);
}
