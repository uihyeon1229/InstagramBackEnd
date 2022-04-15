package com.sparta.hanghae99clone.dto.response;

import com.sparta.hanghae99clone.dto.CommentDto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListResponseDto {

    private Long id;

    private String imageFile;

    private String content;

    private String dayBefore;

    private Long commentCnt;

//    private String userImage;

    private String nickname;

    private List<CommentDto> comments;

}
