package org.example.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.board.vo.Board;

public interface BoardDAO {
  void setSession(SqlSession session);
  List<Board> selectAllBoars();
//  Board selectBoardById(Long id);
//  void insertBoard(Board board);

}
