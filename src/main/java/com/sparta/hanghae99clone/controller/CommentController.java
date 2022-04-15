package com.sparta.hanghae99clone.Controller;


import com.sparta.hanghae99clone.dto.request.CommentRequestDto;
import com.sparta.hanghae99clone.model.Comment;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.CommentRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import com.sparta.hanghae99clone.repository.UserRepository;
import com.sparta.hanghae99clone.security.UserDetailsImpl;
import com.sparta.hanghae99clone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final UserRepository userRepository;
    private final PostRepository postRepository;



    @PostMapping("/api/comments")
    public void createComment(@RequestBody CommentRequestDto requestDto){
//        if(userDetails.getUser()==null){
//            throw new IllegalArgumentException("로그인을 먼저 진행해주세요");
//        }
//        if(requestDto.getComments().length()<1){
//            throw new IllegalArgumentException("댓글을 입력해주세요");
//        }

        Post post = postRepository.findById(requestDto.getPostId()).get();
        User user = userRepository.findById(1L).get();
        commentService.createComment(requestDto,post,user);

    }
    @Transactional
    @DeleteMapping("/api/comments/{commentId}")
    public void deletsComment(@PathVariable("commentId") Long commentId){


        commentRepository.deleteById(commentId);

    }
}
