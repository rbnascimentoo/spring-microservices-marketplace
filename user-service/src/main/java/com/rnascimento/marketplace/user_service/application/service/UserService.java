package com.rnascimento.marketplace.user_service.application.service;

import com.rnascimento.marketplace.user_service.domain.model.User;
import com.rnascimento.marketplace.user_service.domain.port.in.UserDao;
import com.rnascimento.marketplace.user_service.dto.UserRequestDto;
import com.rnascimento.marketplace.user_service.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserResponseDto> findAll() {
        List<User> users = userDao.findAll();
        return users.stream().map(this::toResponseDto).toList();
    }

    public UserResponseDto findById(Long id) {
        User user = userDao.findById(id);
        return user != null ? toResponseDto(user) : null;
    }

    public UserResponseDto create(UserRequestDto dto) {
        User user = toEntity(dto);
        User savedUser = userDao.save(user);
        return toResponseDto(savedUser);
    }

    public UserResponseDto update(Long id, UserRequestDto dto) {
        User user = userDao.findById(id);
        if (user == null) return null;
        updateEntity(user, dto);
        User updatedUser = userDao.save(user);
        return toResponseDto(updatedUser);
    }

    public boolean delete(Long id) {
        return userDao.delete(id);
    }

    public User toEntity(UserRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .active(dto.isActive())
                .role(dto.getRole())
                .build();
    }

    public void updateEntity(User user, UserRequestDto dto) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setActive(dto.isActive());
        user.setRole(dto.getRole());
    }

    public UserResponseDto toResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .active(user.isActive())
                .role(user.getRole())
                .createdAt(user.getCreatedAt() != null ? user.getCreatedAt().toString() : null)
                .updatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt().toString() : null)
                .build();
    }

}
