package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePasswordRequestDto {     /*비밀번호 변경 요청 DTO*/
    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;
}