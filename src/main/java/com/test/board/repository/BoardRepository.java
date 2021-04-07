package com.test.board.repository;

import com.test.board.entity.BoardEntity;
import com.test.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //List<BoardEntity> findAllByOrderByIdAsc();


    //@Query("select b from BoardEntity b join fetch b.comments")
    @EntityGraph(attributePaths = "comments")
    List<BoardEntity> findAll();

    List<BoardEntity> findAllByOrderByIdDesc();
}
