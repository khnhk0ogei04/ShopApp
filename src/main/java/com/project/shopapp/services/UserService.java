package com.project.shopapp.services;

import com.project.shopapp.dtos.UserDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Role;
import com.project.shopapp.models.User;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(UserDTO userDTO) throws DataNotFoundException {
        String phoneNumber = userDTO.getPhoneNumber();
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new RuntimeException("Phone number already exists");
        }
        User newUser = User.builder().fullName(userDTO.getFullName()).phoneNumber(userDTO.getPhoneNumber())
                .address(userDTO.getAddress()).dateOfBirth(userDTO.getDateOfBirth())
                .facebookAccountId(userDTO.getFacebookAccountId())
                .googleAccountId(userDTO.getGoogleAccountId())
                .build();
        Role role = roleRepository.findById(userDTO.getRoleId()).orElseThrow(() -> new DataNotFoundException("Role not found"));
        newUser.setRole(role);
        // Kiem tra neu co accountId, khong yeu cau password
        if (userDTO.getGoogleAccountId() == 0 || userDTO.getFacebookAccountId() == 0) {
            String password = userDTO.getPassword();
//            String encodedPassword = passwordEncoder.encode(password);
//            newUser.setPassword(encodedPassword);
        }
        return userRepository.save(newUser);
    }

    @Override
    public String login(String phoneNumber, String password) {
        return null;
    }
}
