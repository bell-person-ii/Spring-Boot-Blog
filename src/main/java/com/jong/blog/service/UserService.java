package com.jong.blog.service;

import com.jong.blog.domain.User;
import com.jong.blog.dto.AddUserRequest;
import com.jong.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder().email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword())).build()).getId();
    }

}
