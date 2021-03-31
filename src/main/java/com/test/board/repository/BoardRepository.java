package com.test.board.repository;

import com.test.board.entity.BoardEntity;
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

    @EntityGraph(attributePaths = {"comments"})  // LAZY
    List<BoardEntity> findAllById();
    //List<BoardEntity> findAllByOrderByIdDesc();
}
