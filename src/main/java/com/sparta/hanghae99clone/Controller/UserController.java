package com.sparta.hanghae99clone.Controller;

import com.sparta.hanghae99clone.dto.request.SignupRequestDto;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    public ResponseEntity<User> registerUser(@RequestBody SignupRequestDto requestDto){

        User user = userService.registerUser(requestDto);
        return ResponseEntity.ok(user);
    }



}
