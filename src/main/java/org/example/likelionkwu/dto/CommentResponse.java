package org.example.likelionkwu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentResponse {
    private Long commentId;
    private String commentAuthor;
    private String commentContent;
    private Long boardId;
}
