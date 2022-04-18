package com.sparta.hanghae99clone.service;

import com.sparta.hanghae99clone.model.Favorite;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.FavoriteRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final PostRepository postRepository;

    public void favoriteCheck(Long postId, User user) {

//        Favorite favorite = new Favorite(user.getNickname(), user.getId());

        Post post = postRepository.findById(postId).orElseThrow (
                () -> new IllegalArgumentException("여기서오류?")
        );

        String nickname = user.getNickname();

        Optional<Favorite> favorite = favoriteRepository.findByPostIdAndUserId(postId,user.getId());

//        try {
            if (!favorite.isPresent()) {
                Favorite savefavorite = new Favorite(post, user);

                favoriteRepository.save(savefavorite);

            }
            else
            {
            favoriteRepository.deleteById(favorite.get().getId());

            }
//        }
//        catch(Exception error){
//            error.getMessage();
//
//        }

    }
}
