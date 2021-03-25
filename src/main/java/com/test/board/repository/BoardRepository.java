package com.test.board.repository;

import com.test.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    List<BoardEntity> findAll();
    Optional<BoardEntity> findById(Integer boardId);
    void deleteById(Integer boardId);
}
