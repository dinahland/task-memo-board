package org.example.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.memo.entity.Memo;

@Getter
@AllArgsConstructor
public class MemoResponseDto {
    private Long id;
    private String username;
    private String contents;

    public MemoResponseDto(Memo memo){
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
    }
}
