package org.example.likelionkwu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.domain.Comment;
import org.example.likelionkwu.domain.User;
import org.example.likelionkwu.dto.CommentRequest;
import org.example.likelionkwu.repository.BoardRepository;
import org.example.likelionkwu.repository.CommentRepository;
import org.example.likelionkwu.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public boolean createComment(CommentRequest commentRequest, Long boardId) {
        String username = commentRequest.getUsername();
        Board board = boardRepository.findByBoardId(boardId);

        log.info(username);
        log.info(String.valueOf(board.getBoardId()));
        if (username == null) {
            return false;
        } else {
            Comment comment = new Comment(commentRequest, board);
            if (userRepository.findByUsername(username).isEmpty()) {
                User user = new User(username);
                userRepository.save(user);
            }
            commentRepository.save(comment);
            return true;
        }
    }


}
