package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardWithAgeResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final Integer age;

    public BoardWithAgeResponseDto(Board board, Integer age){
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.age = age;
    }
}
