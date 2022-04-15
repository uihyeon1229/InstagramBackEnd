package com.sparta.hanghae99clone.model;

import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private User user;

    public Post(PostRequestDto postRequestDto) {
        this.content = postRequestDto.getContents();
    }

    public Post(User user, PostRequestDto postRequestDto) {
        this.user = user;
        this.content = postRequestDto.getContents();
    }
}
