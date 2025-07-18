package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto {    /*회원 가입 응답 DTO*/
    private Long id;
    private String username;
    private Integer age;
}
