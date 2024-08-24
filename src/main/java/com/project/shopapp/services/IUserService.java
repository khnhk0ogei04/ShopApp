package com.project.shopapp.services;

import com.project.shopapp.dtos.UserDTO;
import com.project.shopapp.models.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public User createUser(UserDTO userDTO) throws Exception;
    String login(String phoneNumber, String password);
}
