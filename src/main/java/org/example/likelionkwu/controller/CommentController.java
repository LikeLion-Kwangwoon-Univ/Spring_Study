package org.example.likelionkwu.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.dto.CommentRequest;
import org.example.likelionkwu.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{boardId}/comment/create")
    public ResponseEntity<String> createBoard(
            @RequestBody CommentRequest commentRequest,
            @PathVariable Long boardId) {
        if (commentService.createComment(commentRequest, boardId)) {
            return ResponseEntity.ok("댓글 작성 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
