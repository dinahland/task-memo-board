package com.example.board.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardRequestDto {      /*게시글 생성 요청 DTO*/
    @NotNull
    private String title;

    @NotNull
    private String contents;

    @NotNull
    private String username;
}
