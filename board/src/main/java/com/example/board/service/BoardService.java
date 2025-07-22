package com.example.board.service;

import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardWithAgeResponseDto;
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

    /*새 게시글 생성, DB 저장 후 BoardResponseDto 형태로 반환*/
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Member member = findMemberByUsername(requestDto.getUsername());
        Board board = new Board(requestDto.getTitle(), requestDto.getContents(), member);
        boardRepository.save(board);
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());

    }

    /*전체 게시글 BoardResponseDto 리스트로 반환*/
    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAll().stream().map(BoardResponseDto::new).toList();
    }

    /*id로 게시글 찾아서 작성 멤버 나이와 함께 반환*/
    public BoardWithAgeResponseDto getBoardById(Long id) {
        Board board = findBoardById(id);
        Member member = board.getMember();
        return new BoardWithAgeResponseDto(board, member.getAge());
    }

    /*id 받아서 게시글 삭제*/
    public void delete(Long id) {
        Board board = findBoardById(id);
        boardRepository.delete(board);
    }

    /*id로 게시글 찾아서 반환*/
    private Board findBoardById(Long id){
        return boardRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다.")
        );
    }

    /* username 으로 멤버 찾아서 반환*/
    private Member findMemberByUsername(String username){
        return memberRepository.findMemberByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "회원 정보를 찾을 수 없습니다.")
        );
    }
}

