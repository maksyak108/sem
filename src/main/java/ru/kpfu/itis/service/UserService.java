package ru.kpfu.itis.service;

import ru.kpfu.itis.dto.CreateUserRequestDto;
import ru.kpfu.itis.dto.UserResponseDto;
import ru.kpfu.itis.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAll();

    Optional<UserResponseDto> findById(Integer id);

    Optional<User> findByEmail(String email);

    UserResponseDto create(CreateUserRequestDto userDto, String url);

    boolean verify(String verificationCode);

    void sendVerificationMail(String mail, String name, String code, String url);
}
