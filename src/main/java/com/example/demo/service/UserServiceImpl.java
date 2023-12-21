package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Userok;
import com.example.demo.exception.AppException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public static final List<UserDTO> userList = new ArrayList<>();

    static {
        userList.add(new UserDTO(1L, "name1"));
        userList.add(new UserDTO(2L, "name5"));
        userList.add(new UserDTO(3L, "name7"));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToDto).
                collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::userToDto)
                .orElseThrow(() -> new AppException("User is not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        Userok userok = userMapper.dtoToUser(userDTO);
        return saveUserAndReturnDto(userok);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Userok user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User is not found", HttpStatus.NOT_FOUND));
        user.setFirstName(userDTO.name());
        return saveUserAndReturnDto(user);
    }

    private UserDTO saveUserAndReturnDto(Userok user) {
        Userok updatedUser = userRepository.save(user);
        return userMapper.userToDto(updatedUser);
    }


}
