package org.example.likelionkwu.service;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.domain.User;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.repository.BoardRepository;
import org.example.likelionkwu.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public boolean createBoard(BoardRequest boardRequest) {
        String username = boardRequest.getUsername();

        if (username == null) {
            return false;
        } else {
            Board board = new Board(boardRequest);
            User user = new User(username);

            userRepository.save(user);
            boardRepository.save(board);
            return true;
        }
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElse(null);
    }

    public List<Board> getBoardsByUsername(String username) {
        return boardRepository.findBoardByBoardAuthor(username);
    }
}
