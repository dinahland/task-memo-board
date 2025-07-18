package org.example.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.memo.dto.MemoRequestDto;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class Memo extends Timestamped{
    @Id     /*PRIMARY KEY*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /*AUTO_INCREMENT*/
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, length = 500)
    private String contents;

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}