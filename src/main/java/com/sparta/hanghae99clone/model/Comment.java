package com.sparta.hanghae99clone.model;

import javax.persistence.*;

import com.sparta.hanghae99clone.dto.request.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    private String nickname;

    public Comment(CommentRequestDto requestDto, Post post, User user) {
        this.contents = requestDto.getComments();
        this.post = post;
        this.user = user;
        this.nickname=user.getNickname();
    }
}
