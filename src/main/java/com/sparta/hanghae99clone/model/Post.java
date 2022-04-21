package com.sparta.hanghae99clone.model;

import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Favorite> favorites = new ArrayList<>();

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public void editContent(PostRequestDto postRequestDto) {

        this.content = postRequestDto.getContents();
    }

}
