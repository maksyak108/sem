package ru.kpfu.itis.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.model.User;

@Data
@Builder
public class UserResponseDto {

    private Integer id;

    private String name;

    private String email;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
