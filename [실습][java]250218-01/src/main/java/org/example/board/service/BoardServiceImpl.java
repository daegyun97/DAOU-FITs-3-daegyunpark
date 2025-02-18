package org.example.board.service;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.board.dao.BoardDAO;
import org.example.board.dao.BoardDAOImpl;
import org.example.board.dao.UserDAO;
import org.example.board.dao.UserDAOImpl;
import org.example.board.mybatis.MyBatisFactory;
import org.example.board.vo.Board;
import org.example.board.vo.User;

public class BoardServiceImpl implements BoardService {
  BoardDAO boardDAO;
  private SqlSessionFactory factory = MyBatisFactory.getSqlSessionFactory();

  public BoardServiceImpl() {
    this.boardDAO = new BoardDAOImpl();
  }
  @Override
  public List<Board> getAllBoars() {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    List<Board> boards = boardDAO.selectAllBoars();
    session.close();
    return boards;
  }
}
