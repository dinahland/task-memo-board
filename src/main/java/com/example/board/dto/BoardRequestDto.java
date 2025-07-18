package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardRequestDto {      /*게시글 생성 요청 DTO*/
    private String title;
    private String contents;
    private String username;
}
