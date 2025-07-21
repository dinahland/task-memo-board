package org.example.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.memo.entity.Memo;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemoResponseDto {
    private final Long id;
    private final String username;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemoResponseDto(Memo memo){
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
        this.createdAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
    }
}
