package com.test.board.repository;

import com.test.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //List<BoardEntity> findAllByOrderByIdAsc();

    @Query(value = "SELECT b.*,\n" +
            "       COUNT(c.content) AS comment_num\n" +
            "FROM boards b\n" +
            "LEFT JOIN comments c ON b.board_id = c.board_id\n" +
            "GROUP BY b.board_id\n" +
            "ORDER BY b.board_id",
            nativeQuery = true)
    List<BoardEntity> findAllByOrderByIdAsc();
}
