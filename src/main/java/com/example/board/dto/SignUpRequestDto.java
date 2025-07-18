package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {     /*회원 가입 요청 DTO*/

    @NotNull
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @Range(min = 1, max = 150)
    private Integer age;

}
