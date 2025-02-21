package org.example.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.board.dto.BoardsDTO;
import org.example.board.vo.Board;
import org.example.board.vo.Like;

public interface BoardDAO {
  void setSession(SqlSession session);
  List<Board> selectAllBoars(String keyword);
  Board selectBoardById(Long id);
  void insertBoard(Board board);
  void deleteBoard(Long id);
  void updateBoard(Board board);
  void updateCount(Long id);
  int getLikeCount(Long id);
  void insertLike(Like like);
  void deleteLike(Like like);
  Like isLike(Like like);

}
