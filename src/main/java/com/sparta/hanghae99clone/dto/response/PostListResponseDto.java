package com.sparta.hanghae99clone.dto.response;

import com.sparta.hanghae99clone.model.Image;
import com.sparta.hanghae99clone.model.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostListResponseDto {

    private Long postId;

    private String imageFile;

    private String content;

    private String dayBefore;

    private Long commentCnt;

    private Long favoriteCnt;

    private String nickname;

    private boolean favoriteStatus;

    public PostListResponseDto(Post post, Image image, String dayBefore, Long commentCnt, Long favoriteCnt, boolean favoriteStatus) {
        this.postId = post.getId();
        this.imageFile = image.getImageFile();
        this.content = post.getContent();
        this.dayBefore = dayBefore;
        this.commentCnt = commentCnt;
        this.nickname = post.getUser().getNickname();
        this.favoriteCnt = favoriteCnt;
        this.favoriteStatus = favoriteStatus;
    }
}
