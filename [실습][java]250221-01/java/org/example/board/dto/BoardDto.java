package org.example.board.dto;

import java.time.LocalDateTime;
import org.example.board.vo.Board;

public class BoardDto {
  private Long id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private String author;
  private Boolean isLiked;

  public BoardDto(Board board, Boolean isLiked) {
    this.id = board.getId();
    this.title = board.getTitle();
    this.content = board.getContent();
    this.createdAt = board.getCreatedAt();
    this.author = board.getAuthor();
    this.isLiked = isLiked;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Boolean getLiked() {
    return isLiked;
  }

  public void setLiked(Boolean liked) {
    isLiked = liked;
  }
}
