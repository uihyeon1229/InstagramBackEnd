package com.sparta.hanghae99clone.controller;


import com.sparta.hanghae99clone.dto.CommentDto;
import com.sparta.hanghae99clone.dto.request.CommentRequestDto;
import com.sparta.hanghae99clone.dto.response.CommentListResponseDto;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.CommentRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import com.sparta.hanghae99clone.repository.UserRepository;
import com.sparta.hanghae99clone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final UserRepository userRepository;
    private final PostRepository postRepository;



    @PostMapping("/api/comments")
    public CommentDto createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        if(userDetails.getUser()==null){
//            throw new IllegalArgumentException("로그인을 먼저 진행해주세요");
//        }
//        if(requestDto.getComments().length()<1){
//            throw new IllegalArgumentException("댓글을 입력해주세요");
//        }

        Post post = postRepository.findById(requestDto.getPostId()).get();
        User user = userDetails.getUser();

        return commentService.createComment(requestDto,post,user);
    }

    @Transactional
    @DeleteMapping("/api/comments/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId){
        commentRepository.deleteById(commentId);
    }

    @GetMapping("/api/comments/{postId}/{page}")
    public CommentListResponseDto showallcomment(@PathVariable Long postId,@PathVariable("page") Integer pageId){
        pageId=pageId-1;
        CommentListResponseDto commentListResponseDto = commentService.showallcomment(postId,pageId);
        return commentListResponseDto;
    }
}