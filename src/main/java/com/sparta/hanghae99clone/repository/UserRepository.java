package com.sparta.hanghae99clone.repository;

import com.sparta.hanghae99clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNickname(String nickname);
    boolean existsByUsername(String username);



}
