package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Userok;

public interface UserMapper {
    Userok dtoToUser(UserDTO user);
    UserDTO userToDto(Userok userok);
}
