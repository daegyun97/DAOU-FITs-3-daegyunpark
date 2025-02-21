package org.example.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.board.vo.Board;
import org.example.board.vo.Comment;

public interface CommentDAO {
  void setSession(SqlSession session);
  List<Comment> selectCommentById(Long id);
  void insertComment(Comment comment);
  void deleteComment(Long id);
  int getCount(Long id);

}
