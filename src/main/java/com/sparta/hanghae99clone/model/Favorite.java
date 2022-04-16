package com.sparta.hanghae99clone.model;

import com.sparta.hanghae99clone.dto.FavoriteDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    private User user;

    public Favorite(Post post, User user) {
        this.post = post;
        this.user = user;

    }

//    public Favorite(String nickname, Long id) {
//
//        this.nickname = user.getNickname();
//        this.id = user.getId();
//
//    }
}