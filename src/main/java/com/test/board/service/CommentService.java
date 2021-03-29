package com.test.board.service;

import com.test.board.entity.BoardEntity;
import com.test.board.entity.CommentEntity;
import com.test.board.repository.BoardRepository;
import com.test.board.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentEntity> getCommentList(Integer boardId) {
        return commentRepository.findAllById(boardId);
    }
}
