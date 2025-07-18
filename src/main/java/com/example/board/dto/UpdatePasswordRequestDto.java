package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePasswordRequestDto {     /*비밀번호 변경 요청 DTO*/
    private String oldPassword;
    private String newPassword;
}