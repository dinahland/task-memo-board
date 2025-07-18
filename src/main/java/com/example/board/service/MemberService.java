package com.example.board.service;

import com.example.board.dto.SignUpRequestDto;
import com.example.board.dto.SignUpResponseDto;
import com.example.board.dto.UpdatePasswordRequestDto;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(SignUpRequestDto requestDto) {
        Member member = new Member(requestDto.getUsername(), requestDto.getPassword(), requestDto.getAge());
        Member savedMember = memberRepository.save(member);
        return new SignUpResponseDto(savedMember.getId(),savedMember.getUsername(),savedMember.getAge());
    }

    public SignUpResponseDto getMemberById(Long id) {
        Member member = findMemberById(id);
        return new SignUpResponseDto(member.getId(), member.getUsername(), member.getAge());
    }

    @Transactional
    public Long updatePassword(Long id, UpdatePasswordRequestDto requestDto) {
        Member member = findMemberById(id);
        if(!member.getPassword().equals(requestDto.getOldPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        member.updatePassword(requestDto.getNewPassword());
        return id;
    }


    /*id로 멤버 찾아서 반환*/
    private Member findMemberById(Long id){
        return memberRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "회원 정보를 찾을 수 없습니다.")
        );
    }
}
