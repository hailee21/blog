package com.test.board.service;

import com.test.board.entity.BoardEntity;
import com.test.board.repository.BoardRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // why do I have to add constructor?
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardEntity> getBoardlist() {
        List<BoardEntity> boardList = boardRepository.findAll();
        List<BoardEntity> returnList = new ArrayList<>();

        for(int i=0; i<boardList.size(); i++){
            System.out.println(boardList.get(i).getId());
            System.out.println(boardList.get(i).getTitle());
        }

        for(BoardEntity board : boardList) {
            BoardEntity boardOne = BoardEntity.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();

            returnList.add(boardOne);
        }
        return returnList;
    }

    public BoardEntity getBoard(Integer boardId) {
        Optional<BoardEntity> board = boardRepository.findById(boardId);

        BoardEntity returnBoard = BoardEntity.builder()
                .id(board.get().getId())
                .title(board.get().getTitle())
                .content(board.get().getContent())
                .views(board.get().getViews())
                .build();

        return returnBoard;
    }

    public void deleteBoard(Integer boardId) {
        boardRepository.deleteById(boardId);
    }
}
