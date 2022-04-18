package com.sparta.hanghae99clone.controller;

import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.UserRepository;
import com.sparta.hanghae99clone.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class FavoriteController {
    private final FavoriteService favoriteService;
    private final UserRepository userRepository;

    @PutMapping("/api/favorite/{postId}")
    public String favoriteCheck(@PathVariable("postId") Long postId){
        User user = userRepository.findById(1L).get();
        favoriteService.favoriteCheck(postId,user);
        return " 좋아요";
    }
}