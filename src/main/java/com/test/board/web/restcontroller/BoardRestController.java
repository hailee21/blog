package com.test.board.web.restcontroller;

import com.test.board.entity.BoardEntity;
import com.test.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/boards")
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public List<BoardEntity> getBoardList() {
        return boardService.getBoardList();
    }

    @PostMapping("")
    public Object createBoard(@RequestBody BoardEntity boardEntity){
        return boardService.createBoard(boardEntity);
    }

    @GetMapping("/{boardId}")
    public BoardEntity getBoard(@PathVariable Integer boardId) {
        return boardService.getBoard(boardId);
    }

    @PutMapping("/{boardId}")
    public BoardEntity updateBoard(@PathVariable Integer boardId, @RequestBody BoardEntity boardEntity) {
        return boardService.updateBoard(boardId, boardEntity);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable Integer boardId) {
        boardService.deleteBoard(boardId);
    }

}
