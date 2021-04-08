package com.test.board.service;

import com.test.board.entity.BoardEntity;
import com.test.board.repository.BoardRepository;
import com.test.board.repository.CommentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    public List<BoardEntity> getBoardList() {
        List<BoardEntity> bList = boardRepository.findAllByOrderByIdDesc();
        return bList;
    }

    public List<BoardEntity> searchBoard(String searchValue) {
        List<BoardEntity> bList = boardRepository.findBySearchValue(searchValue); //(Sort.by(Sort.Direction.ASC, "searchValue"));
        return bList;
    }

    public List<BoardEntity> getBoardListBySortId(Integer sortId) {
        List<BoardEntity> bList = new ArrayList<>();
        if (sortId == 0) {
            bList = boardRepository.findAllByOrderByIdDesc();
        } else if(sortId == 1) {
            bList = boardRepository.findByOrderByTitle();
        } else {
            //bList = boardRepository.findByCommentCountOrderByDesc();  // 댓글 수에 의한 정렬
        }

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
        BoardEntity savedBoard = boardRepository.findById(boardId).orElseThrow(NoSuchElementException::new);
        savedBoard.setTitle(boardEntity.getTitle());
        savedBoard.setContent(boardEntity.getContent());
        return boardRepository.save(savedBoard);
    }

    public void deleteBoard(Integer boardId) {
        boardRepository.deleteById(boardId);
    }
}
