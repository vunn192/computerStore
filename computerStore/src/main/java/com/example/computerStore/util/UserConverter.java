package com.example.computerStore.util;


import com.example.computerStore.dto.UserDTO;
import com.example.computerStore.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(
                user.get_id(),
                user.get_username(),
                user.get_email(),
                user.get_password());
    }
    public static List<UserDTO> toUsersDTO(List<User> userList) {
        List<UserDTO> usersDTOList = new ArrayList<>();

        for (User c: userList){
            usersDTOList.add(UserConverter.toUserDTO(c));
        }
        return usersDTOList;
    }

    public static User toUser(UserDTO userDTO){
        return new User(
                userDTO.get_id(),
                userDTO.get_username(),
                userDTO.get_email(),
                userDTO.get_password());
    }
}
