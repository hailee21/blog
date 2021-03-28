package com.test.board.service;

import com.test.board.entity.BoardEntity;
import com.test.board.entity.CommentEntity;
import com.test.board.repository.BoardRepository;
import com.test.board.repository.CommentRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    public List<BoardEntity> getBoardlist() {
        List<BoardEntity> boardList = boardRepository.findAll();

        for(int i=0; i<boardList.size(); i++){
            System.out.println(boardList.get(i).getId());
            System.out.println(boardList.get(i).getTitle());
        }

        return boardList;
    }

    public BoardEntity getBoard(Integer boardId) {
        Optional<BoardEntity> board = boardRepository.findById(boardId);

        return board.orElseThrow(() -> new NoSuchElementException());
    }

    public void deleteBoard(Integer boardId) {
        boardRepository.deleteById(boardId);
    }
}
