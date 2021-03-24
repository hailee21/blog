package com.test.blog.repository;

import com.test.blog.vo.BoardVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardVo, Integer> {
    List<BoardVo> findAll();
}
