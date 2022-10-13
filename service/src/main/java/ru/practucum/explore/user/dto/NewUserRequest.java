package ru.practucum.explore.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequest {

    @NonNull
    @NotBlank
    String email;

    @NonNull
    @NotBlank
    String name;
}
