package com.example.space.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @Pattern(regexp ="^[a-zA-Z0-9]{3,}$")
    private String nickname;

    @Pattern(regexp = ".{4,}")
    private String password;

    @Pattern(regexp = ".{4,}")
    private String checkPassword;
}
