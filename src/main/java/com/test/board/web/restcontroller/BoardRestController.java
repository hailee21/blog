package com.test.board.web.restcontroller;

import com.test.board.entity.BoardEntity;
import com.test.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/job")
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping("/getBoard")
    public String getBoard(@RequestParam(name="id", required=true) Integer boardId, Model model) {
        BoardEntity board = boardService.getBoard(boardId);
        model.addAttribute("board", board);
        return "board/board_read";
    }
}
