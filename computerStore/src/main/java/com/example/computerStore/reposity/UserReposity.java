package com.example.computerStore.reposity;

import java.util.Optional;

import com.example.computerStore.dto.UserDTO;
import com.example.computerStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserReposity extends JpaRepository<User, Long> {
    @Query("select u from User u where u._username = :username")
    public Optional<User> findByUsername(String username);
}
