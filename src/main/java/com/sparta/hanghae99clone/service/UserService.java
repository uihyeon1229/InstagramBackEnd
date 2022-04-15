package com.sparta.hanghae99clone.service;

import com.sparta.hanghae99clone.dto.request.SignupRequestDto;
import com.sparta.hanghae99clone.model.User;
import com.sparta.hanghae99clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerUser(SignupRequestDto requestDto) {

        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String nickname = requestDto.getNickname();
        // 중복 로그인 확인
        if (userRepository.existsByUsername(username)){
            throw new IllegalArgumentException("이미 사용중인 아이디 입니다!");
        }
        if (userRepository.existsByNickname(nickname)){
            throw new IllegalArgumentException("이미 사용중인 닉네임 입니다!");
        }
        if(!username.matches("^[a-z0-9-_]{3,10}$")){
            throw new IllegalArgumentException("아이디는 영어와 숫자로 3~9자리로 입력하셔야 합니다!");
        }
        if(!requestDto.getPassword().matches("^[a-z0-9-_]{4,10}$")){
            throw new IllegalArgumentException("비빌번호는 영어와 숫자로 4~12 자리로 입력하셔야 합니다!");
        }
        if(!requestDto.getNickname().matches("^[a-zA-Z0-9ㄱ-ㅎ가-힣_]{2,10}$")){
            throw new IllegalArgumentException("닉네임은 특수문자 제외한 2글자이상 10글자 이내 완성된 글자여야합니다.");
        }

        User user = new User(username, password,nickname);
        return userRepository.save(user);
    }

}
