package com.example.board.controller;

import com.example.board.dto.SignUpRequestDto;
import com.example.board.dto.SignUpResponseDto;
import com.example.board.dto.UpdatePasswordRequestDto;
import com.example.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){
        return new ResponseEntity<>(memberService.signUp(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignUpResponseDto> getMemberById(@PathVariable Long id){
        return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Long> updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordRequestDto requestDto){
        return new ResponseEntity<>(memberService.updatePassword(id, requestDto), HttpStatus.OK);
    }
}
