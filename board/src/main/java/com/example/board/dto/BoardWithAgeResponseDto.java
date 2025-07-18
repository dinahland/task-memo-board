package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardWithAgeResponseDto {
    private Long id;
    private String title;
    private String contents;
    private Integer age;

    public BoardWithAgeResponseDto(Board board, Integer age){
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.age = age;
    }
}
