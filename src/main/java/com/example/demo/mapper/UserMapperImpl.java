package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Userok;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{

    @Override
    public Userok dtoToUser(UserDTO user) {
        Userok userok = new Userok();
        userok.setId(user.id());
        userok.setFirstName(user.name());
        userok.setLastName("Nullyaka");
        return userok;
    }

    @Override
    public UserDTO userToDto(Userok userok) {
        return new UserDTO(userok.getId(), userok.getFirstName());
    }
}
