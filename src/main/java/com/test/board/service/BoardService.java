package com.test.board.service;

import com.test.board.entity.BoardEntity;
import com.test.board.entity.CommentEntity;
import com.test.board.repository.BoardRepository;
import com.test.board.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


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

    public List<BoardEntity> getBoardList() {
        List<BoardEntity> bList = boardRepository.findAll();
        return bList;
    }

    public BoardEntity getBoard(Integer boardId) {
        return boardRepository.findById(boardId).orElseThrow(NoSuchElementException::new);
    }

    public Object createBoard(BoardEntity boardEntity) {
        return boardRepository.save(boardEntity);
    }

    public BoardEntity updateBoard(Integer boardId, BoardEntity boardEntity) {
        // Jpa dirty checking 덕택에 update 하지 않아도 DB에 반영된다.
        System.out.println("여기 s1");
        BoardEntity savedBoard = boardRepository.findById(boardId).orElseThrow(NoSuchElementException::new);
        System.out.println("여기 s2");
        savedBoard.setTitle(boardEntity.getTitle());
        savedBoard.setContent(boardEntity.getContent());
        System.out.println("여기 s3");
        return boardRepository.save(savedBoard);
    }

    public void deleteBoard(Integer boardId) {
        //commentRepository.
        boardRepository.deleteById(boardId);
    }
}
