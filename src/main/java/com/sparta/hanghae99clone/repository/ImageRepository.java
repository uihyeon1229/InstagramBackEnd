package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.Image;
import com.sparta.hanghae99clone.model.Post;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByPost(Post post);
}
