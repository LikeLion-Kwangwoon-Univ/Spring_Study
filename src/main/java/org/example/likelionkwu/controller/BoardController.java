package org.example.likelionkwu.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.repository.BoardRepository;
import org.example.likelionkwu.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createBoard(@RequestBody BoardRequest boardRequest) {
        if (boardService.createBoard(boardRequest)) {
            return ResponseEntity.ok("질문글 생성 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Board>> getAllBoards() {
        List<Board> boards = boardService.getAllBoards();
        if (boards.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(boards);
        }
    }

    @GetMapping("/boardId/{boardId}")
    public ResponseEntity<Board> getBoardByBoardId(@PathVariable Long boardId) {
        Board board = boardService.getBoardById(boardId);
        if (board == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(board);
        }
    }

    @GetMapping("/boardAuthor/{boardAuthor}")
    public ResponseEntity<List<Board>> getBoardByBoardAuthor(@PathVariable String boardAuthor) {
        List<Board> boards = boardRepository.findBoardByBoardAuthor(boardAuthor);
        if (boards.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(boards);
        }
    }
}
