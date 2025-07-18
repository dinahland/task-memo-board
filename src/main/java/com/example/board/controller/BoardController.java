package com.example.board.controller;

import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardWithAgeResponseDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    /*게시글 생성 API*/
    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(@Validated @RequestBody BoardRequestDto requestDto){
        return new ResponseEntity<>(boardService.createBoard(requestDto), HttpStatus.CREATED);
    }

    /*게시글 전체 조회 API*/
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> getBoards(){
        List<BoardResponseDto> boardsList = boardService.getBoards();
        return new ResponseEntity<>(boardsList, HttpStatus.OK);
    }

    /*id로 게시글 조회 API*/
    @GetMapping("/{id}")
    public ResponseEntity<BoardWithAgeResponseDto> getBoardById(@PathVariable Long id){
        return new ResponseEntity<>(boardService.getBoardById(id), HttpStatus.OK);
    }

    /*게시글 삭제 API*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
