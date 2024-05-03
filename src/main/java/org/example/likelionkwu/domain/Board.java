package org.example.likelionkwu.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.likelionkwu.dto.BoardRequest;

@Entity(name = "Board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 20, nullable = false)
    private String boardTitle;

    @Column(length = 20, nullable = false)
    private String boardAuthor;

    @Column
    private String boardContent;

    public Board(BoardRequest boardRequest) {
        this.boardTitle = boardRequest.getBoardTitle();
        this.boardContent = boardRequest.getBoardContent();
        this.boardAuthor = boardRequest.getUsername();
    }
}
