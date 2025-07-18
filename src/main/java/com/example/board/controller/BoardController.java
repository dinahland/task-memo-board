package com.example.board.controller;

import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    /*게시글 생성 API*/
    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardRequestDto requestDto){
        return new ResponseEntity<>(boardService.createBoard(requestDto), HttpStatus.CREATED);
    }

    /*게시글 전체 조회 API*/
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> getBoards(){
        List<BoardResponseDto> boardsList = boardService.getBoards();
        return new ResponseEntity<>(boardsList, HttpStatus.OK);
    }
}
