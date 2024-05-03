package org.example.likelionkwu.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<String> createBoard(@RequestBody BoardRequest boardRequest) {
        if (boardService.createBoard(boardRequest)) {
            return ResponseEntity.ok("질문글 생성 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
