package com.example.board.service;

import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Member member = findMemberByUsername(requestDto.getUsername());

        Board board = new Board(requestDto.getTitle(), requestDto.getContents(), member);

        boardRepository.save(board);

        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());

    }

    /* username 으로 멤버 찾아서 반환*/
    private Member findMemberByUsername(String username){
        return memberRepository.findMemberByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "회원 정보를 찾을 수 없습니다.")
        );
    }

    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAll().stream().map(BoardResponseDto::new).toList();
    }
}

