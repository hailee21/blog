package com.test.blog.service;

import com.test.blog.dto.BoardDto;
import com.test.blog.entity.BoardEntity;
import com.test.blog.repository.BoardRepository;
import com.test.blog.vo.BoardVo;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private BoardRepository boardRepository;

    public List<BoardVo> getBoardlist() {
        List<BoardVo> boardVoList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(BoardVo board : boardVoList) {
            // builder()의 위치는 Vo, Dto 중 어느 곳이 더 효율적인가?
            // Vo, Dto를 같이 쓰는 것보다 Entity, Dto가 더 효율적일까? 이때의 builder의 위치는?
            BoardVo boardVo = BoardVo.builder()
                    .boardId(board.getBoardId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .userId(board.getUserId())
                    .build();

            boardVoList.add(boardVo);
        }
        return boardVoList;
    }
}
