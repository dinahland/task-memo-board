package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardResponseDto {     /*게시글 생성 응답 DTO*/
    private Long id;
    private String title;
    private String contents;

}
