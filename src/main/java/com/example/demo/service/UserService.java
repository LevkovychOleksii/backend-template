package com.example.demo.service;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

    UserDTO getUserById(Long id);

    UserDTO addUser(UserDTO user);

    void deleteUser(Long id);

    UserDTO updateUser(Long id, UserDTO user);
}
