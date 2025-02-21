package org.example.board.service;

import java.util.List;
import org.example.board.dto.CommentDTO;
import org.example.board.vo.Board;
import org.example.board.vo.Comment;

public interface CommentService {
  List<CommentDTO> getComments(Long id);
  void createComment(Comment comment);
  void removeComment(Long id);


}
