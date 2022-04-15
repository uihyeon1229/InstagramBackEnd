package com.sparta.hanghae99clone.service;

import com.sparta.hanghae99clone.dto.request.CommentRequestDto;
import com.sparta.hanghae99clone.model.Comment;
import com.sparta.hanghae99clone.model.Post;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.CommentRepository;
import com.sparta.hanghae99clone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }



    public void createComment(CommentRequestDto requestDto, Post post, User user) {

        Comment comment = new Comment(requestDto,post,user);
        commentRepository.save(comment);
    }
}
