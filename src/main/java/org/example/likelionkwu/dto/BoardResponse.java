package org.example.likelionkwu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.likelionkwu.domain.Board;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardResponse {
    private String boardAuthor;
    private String boardTitle;
    private String boardContent;

    public BoardResponse(Board board) {
        this.boardAuthor = board.getBoardAuthor();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
    }
}
