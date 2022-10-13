package ru.practucum.explore.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    long id;

    @NonNull
    @NotBlank
    String name;

    @NonNull
    @NotBlank
    String email;
}
