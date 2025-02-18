package org.example.board.dao;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.board.vo.Board;

public class BoardDAOImpl implements BoardDAO {
  private SqlSession sqlSession;

  public BoardDAOImpl() {
  }

  @Override
  public void setSession(SqlSession session) {
    this.sqlSession = session;
  }

  @Override
  public List<Board> selectAllBoars() {
    return sqlSession.selectList("example.MyBoard.selectAllBoars");
  }
}
