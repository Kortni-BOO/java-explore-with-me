package ru.practucum.explore.user.mapper;

import org.springframework.stereotype.Component;
import ru.practucum.explore.user.dto.UserDto;
import ru.practucum.explore.user.dto.UserShortDto;
import ru.practucum.explore.user.model.User;

@Component
public class UserMapper {
    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getEmail(),
                user.getId(),
                user.getName()
        );
    }

    public User toUser(UserDto user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public User toUserFromUserShort(UserShortDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .build();
        return user;
    }

    public UserShortDto toUserShortDto(User user) {
        UserShortDto dto = UserShortDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
        return dto;
    }
}
