package com.test.board.repository;

import com.test.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
//    List<CommentEntity> findAllByBoardEntity_Id(Integer boardId);

    List<CommentEntity> findByBoardEntityId(Integer boardId);
}
