package org.example.board.dao;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.board.dto.BoardsDTO;
import org.example.board.vo.Board;
import org.example.board.vo.Like;

public class BoardDAOImpl implements BoardDAO {
  private SqlSession sqlSession;

  public BoardDAOImpl() {
  }

  @Override
  public void setSession(SqlSession session) {
    this.sqlSession = session;
  }

  @Override
  public List<Board> selectAllBoars(String keyword) {
    return sqlSession.selectList("example.MyBoard.selectAllBoars","%"+keyword+"%");
  }

  @Override
  public Board selectBoardById(Long id) {
    return sqlSession.selectOne("example.MyBoard.selectBoarById",id);
  }

  @Override
  public void insertBoard(Board board) {
    sqlSession.insert("example.MyBoard.insertBoard",board);
  }

  @Override
  public void deleteBoard(Long id) {
    sqlSession.update("example.MyBoard.deleteBoardById",id);
  }

  @Override
  public void updateBoard(Board board) {
    sqlSession.update("example.MyBoard.updateBoard",board);
  }

  @Override
  public void updateCount(Long id) {
    sqlSession.update("example.MyBoard.updateCount",id);
  }

  @Override
  public int getLikeCount(Long id) {
    return sqlSession.selectOne("example.MyBoard.selectCnt",id);
  }

  @Override
  public void insertLike(Like like) {
    sqlSession.insert("example.MyBoard.like",like);
  }

  @Override
  public void deleteLike(Like like) {
    sqlSession.insert("example.MyBoard.dislike", like);
  }

  @Override
  public Like isLike(Like like) {
    return sqlSession.selectOne("example.MyBoard.selectLikeCnt",like);
  }

}
