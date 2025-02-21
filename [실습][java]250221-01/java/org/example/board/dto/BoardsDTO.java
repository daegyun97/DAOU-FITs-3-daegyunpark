package org.example.board.dto;

import java.time.LocalDateTime;
import org.example.board.vo.Board;

public class BoardsDTO {
  private Long id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private String author;
  private Long cnt;
  private int likeCnt;
  private int commentCnt;

  public BoardsDTO(Board board, int likeCnt, int commentCnt) {
    this.id = board.getId();
    this.title = board.getTitle();
    this.content = board.getContent();
    this.createdAt = board.getCreatedAt();
    this.author = board.getAuthor();
    this.cnt = board.getCnt();
    this.likeCnt = likeCnt;
    this.commentCnt = commentCnt;
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

  public Long getCnt() {
    return cnt;
  }

  public void setCnt(Long cnt) {
    this.cnt = cnt;
  }

  public int getLikeCnt() {
    return likeCnt;
  }

  public void setLikeCnt(int likeCnt) {
    this.likeCnt = likeCnt;
  }

  public int getCommentCnt() {
    return commentCnt;
  }

  public void setCommentCnt(int commentCnt) {
    this.commentCnt = commentCnt;
  }
}
