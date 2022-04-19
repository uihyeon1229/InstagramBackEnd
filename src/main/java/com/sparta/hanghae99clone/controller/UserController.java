package com.sparta.hanghae99clone.controller;

import com.sparta.hanghae99clone.dto.request.IdCheckRequestDto;
import com.sparta.hanghae99clone.dto.request.SignupRequestDto;
import com.sparta.hanghae99clone.dto.response.IdCheckResponseDto;
import com.sparta.hanghae99clone.dto.response.IsLoginResponseDto;
import com.sparta.hanghae99clone.repository.UserRepository;
import com.sparta.hanghae99clone.security.UserDetailsImpl;
import com.sparta.hanghae99clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@RequestParam("image") MultipartFile multipartFile ,SignupRequestDto requestDto)throws IOException {

        try {
            userService.registerUser(multipartFile, requestDto);
        }
        catch(Exception e){
            return "Signup Failed...";
        }
        return "Signup Success!";
    }

    @GetMapping("/api/user/islogin")
    public IsLoginResponseDto isloginUser(@AuthenticationPrincipal UserDetailsImpl user){

        IsLoginResponseDto result=new IsLoginResponseDto();
        result.setUsername(user.getUsername());
        result.setNickname(user.getNickname());
        result.setImage_src(userRepository.findByUsername(user.getUsername()).get().getImageSrc());
        System.out.println(result);
        return result;

    }
    //아이디 중복검사
    @PostMapping("/user/idcheck")
    public IdCheckResponseDto vaildId(@RequestBody IdCheckRequestDto requestDto) {

        return userService.vaildId(requestDto);
    }

}