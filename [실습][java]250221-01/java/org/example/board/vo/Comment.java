package org.example.board.vo;

import java.time.LocalDateTime;

public class Comment {
  private Long id;
  private Long boardId;
  private String content;
  private String authorId;
  private LocalDateTime createdAt;
  private LocalDateTime deletedAt;

  public Comment(Long boardId,String content, String authorId) {
    this.boardId = boardId;
    this.content = content;
    this.authorId = authorId;
  }

  public Comment(Long id,Long boardId, String content, String authorId, LocalDateTime createdAt) {
    this.id = id;
    this.boardId = boardId;
    this.content = content;
    this.authorId = authorId;
    this.createdAt = createdAt;
  }

  public Long getBoardId() {
    return boardId;
  }

  public void setBoardId(Long boardId) {
    this.boardId = boardId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return authorId;
  }

  public void setAuthor(String author) {
    this.authorId = author;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(LocalDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }
}
