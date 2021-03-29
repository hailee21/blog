package com.test.board.repository;

import com.test.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findAllById(Integer boardId);

    @Query("SELECT r FROM comments r WHERE r.board_id = ?1 ORDER BY r.rno ASC")
    List<CommentEntity> getRepliesOfBoard(Integer boardId);
}
