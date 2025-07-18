package org.example.memo.service;

import org.example.memo.dto.MemoRequestDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.entity.Memo;
import org.example.memo.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);
        // DB 저장
        Memo saveMemo = memoRepository.save(memo);
        // Entity -> ResponseDto 반환
        return new MemoResponseDto(saveMemo);
    }

    public List<MemoResponseDto> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = findMemo(id);

        memo.update(requestDto);

        return id;
    }

    public Long deleteMemo(Long id) {
        Memo memo = findMemo(id);

        memoRepository.delete(memo);

        return id;
    }

    private Memo findMemo(Long id){
        return memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택하신 메모는 존재하지 않습니다.")
        );
    }
}
