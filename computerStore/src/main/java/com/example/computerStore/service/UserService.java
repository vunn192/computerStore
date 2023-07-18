package com.example.computerStore.service;

import com.example.computerStore.dto.UserDTO;
import com.example.computerStore.model.User;
import com.example.computerStore.reposity.UserReposity;
import com.example.computerStore.util.UserConverter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserReposity userReposity;

    @Autowired
    public UserService(PasswordEncoder encoder, UserReposity userReposity) {
        this.encoder = encoder;
        this.userReposity = userReposity;
    }
    public UserDTO create(UserDTO userDTO){
        User user = UserConverter.toUser(userDTO);
        user.set_password(encoder.encode(userDTO.get_password()));
        User createdUser = userReposity.save(user);
        createdUser.set_password(null);
        return UserConverter.toUserDTO(createdUser);
    }

    public Optional<User> findByUsername(String username) {
        Optional<User> userOpt = userReposity.findByUsername(username);
        if (!userOpt.isPresent()) {
            throw new RuntimeException("Not Found");
        }

        return userOpt;
    }
}
