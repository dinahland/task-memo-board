package org.example.memo.repository;

import org.example.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    /*모든 메모 SELECT 수정 시간 내림차순 정렬*/
    List<Memo> findAllByOrderByModifiedAtDesc();
    /*keyword 포함 메모 SELECT 수정 시간 내림차순 정렬*/
    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
}
