package org.example.board.dto;

import java.time.LocalDateTime;
import org.example.board.vo.Comment;

public class CommentDTO {
  private Long id;
  private Long boardId;
  private String content;
  private String authorName;
  private LocalDateTime createdAt;

  public CommentDTO(Comment comment, String authorName) {
    this.id = comment.getId();
    this.boardId = comment.getBoardId();
    this.content = comment.getContent();
    this.authorName = authorName;
    this.createdAt = comment.getCreatedAt();
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setBoardId(Long boardId) {
    this.boardId = boardId;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
