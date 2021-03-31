package com.test.board.web.controller;

import com.test.board.entity.BoardEntity;
import com.test.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String getBoardList(Model model) {
        List<BoardEntity> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board/board_main";
    }

    @GetMapping("/{boardId}")
    public String getBoard(@PathVariable Integer boardId, Model model) {
        System.out.println("boardController");
        model.addAttribute("board", boardService.getBoard(boardId));
        return "board/board_read";
    }

    @GetMapping("/create")
    public String createBoard() {
        return "board/board_add";
    }

    @PostMapping("/create")
    public String createBoard(@RequestBody BoardEntity boardEntity) {
        Object board = boardService.createBoard(boardEntity);
        return "redirect:/boards";
    }

    @PostMapping("/update/{boardId}")
    public String updateBoard(@PathVariable Integer boardId, @RequestBody BoardEntity boardEntity) {
        BoardEntity board = boardService.updateBoard(boardId, boardEntity);
        return "";
    }

    @PostMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable Integer boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:";
    }

}