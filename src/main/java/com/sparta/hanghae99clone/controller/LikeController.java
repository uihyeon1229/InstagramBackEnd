package com.sparta.hanghae99clone.controller;

import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.UserRepository;
import com.sparta.hanghae99clone.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;
    private final UserRepository userRepository;

    @PutMapping("/api/likes/{postId}")
    public void addOrDelLike(@PathVariable Long postId) {
        User user = userRepository.findById(1L).get();
        likeService.addOrDelLike(postId, user);
    }
}
