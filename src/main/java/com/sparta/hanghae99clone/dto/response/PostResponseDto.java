package com.sparta.hanghae99clone.dto.response;

import com.sparta.hanghae99clone.model.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {

    private Long postId;

    private String contents;

    public PostResponseDto(Post post) {
        this.postId = post.getId();
        this.contents = post.getContent();
    }
}
