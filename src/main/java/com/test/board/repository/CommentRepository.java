package com.test.board.repository;

import com.test.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
//    List<CommentEntity> findAllByBoardEntity_Id(Integer boardId);

    List<CommentEntity> findByBoardEntityId(Integer boardId);

//    @Query("select c from CommentEntity c join fetch c.boardEntity.id")
//    @EntityGraph("BoardEntity.comments")
//    default List<CommentEntity> findAll() {
//        return null;
//    }
}
