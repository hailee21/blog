package com.test.board.repository;

import com.test.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //List<BoardEntity> findAllByOrderByIdAsc();

    @EntityGraph(attributePaths = "comments")
    List<BoardEntity> findAll();

    @EntityGraph(attributePaths = "comments")
    List<BoardEntity> findAllByOrderByIdDesc();

//    @EntityGraph(attributePaths = "comments")
//    List<BoardEntity> findBySearchValue(String searchValue);

    @EntityGraph(attributePaths = "comments")
    List<BoardEntity> findByOrderByTitle();

    //@EntityGraph(attributePaths = "comments")
    //List<BoardEntity> findByCommentCountOrderByDesc();
}
