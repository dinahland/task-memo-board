package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {     /*회원 가입 요청 DTO*/

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "유효하지 않은 이메일입니다.")
    private final String email;

    @NotNull
    private final String username;

    @NotBlank
    private final String password;

    @NotNull
    @Range(min = 1, max = 150)
    private final Integer age;

}
