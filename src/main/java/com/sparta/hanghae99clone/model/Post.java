package com.sparta.hanghae99clone.model;

import com.sparta.hanghae99clone.dto.request.PostRequestDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public void editContent(PostRequestDto postRequestDto) {
        this.content = postRequestDto.getContents();
    }
}
