package com.sparta.hanghae99clone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageFile;

    @ManyToOne
    private Post post;

    public Image(String uploadImageUrl, Post post) {
        this.post = post;
        this.imageFile = uploadImageUrl;
    }
}
