package com.example.board.controller;

import com.example.board.dto.SignUpRequestDto;
import com.example.board.dto.SignUpResponseDto;
import com.example.board.dto.UpdatePasswordRequestDto;
import com.example.board.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    /*회원 가입 API*/
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@Validated @RequestBody SignUpRequestDto requestDto, HttpServletRequest request){
        SignUpResponseDto responseDto = memberService.signUp(requestDto);
        HttpSession session = request.getSession();         //새로운 세션 생성
        session.setAttribute("signupUser", responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    /* id로 회원 조회 API*/
    @GetMapping("/{id}")
    public ResponseEntity<SignUpResponseDto> getMemberById(@PathVariable Long id){
        return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
    }

    /*비밀번호 변경 API*/
    @PatchMapping("/{id}")
    public ResponseEntity<Long> updatePassword(@PathVariable Long id, @Validated @RequestBody UpdatePasswordRequestDto requestDto){
        return new ResponseEntity<>(memberService.updatePassword(id, requestDto), HttpStatus.OK);
    }
}
