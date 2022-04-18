package com.sparta.hanghae99clone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageFile;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Image(String uploadImageUrl, Post post) {
        this.post = post;
        this.imageFile = uploadImageUrl;
    }
}
