package org.example.board.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.board.dao.BoardDAO;
import org.example.board.dao.BoardDAOImpl;
import org.example.board.dao.CommentDAO;
import org.example.board.dao.CommentDAOImpl;
import org.example.board.dao.UserDAO;
import org.example.board.dao.UserDAOImpl;
import org.example.board.dto.BoardDto;
import org.example.board.dto.BoardsDTO;
import org.example.board.mybatis.MyBatisFactory;
import org.example.board.vo.Board;
import org.example.board.vo.Like;
import org.example.board.vo.User;

public class BoardServiceImpl implements BoardService {
  BoardDAO boardDAO;
  CommentDAO commentDAO;
  private SqlSessionFactory factory = MyBatisFactory.getSqlSessionFactory();

  public BoardServiceImpl() {
    this.commentDAO = new CommentDAOImpl();
    this.boardDAO = new BoardDAOImpl();
  }

  @Override
  public List<BoardsDTO> getAllBoars(String keyWord) {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    commentDAO.setSession(session);

    List<BoardsDTO> boardList = new ArrayList<>();
    List<Board>boards = boardDAO.selectAllBoars(keyWord);
    for (Board board : boards) {
      int commentCnt = commentDAO.getCount(board.getId());
      int likeCnt = boardDAO.getLikeCount(board.getId());
      boardList.add(new BoardsDTO(board,likeCnt,commentCnt));
    }
    session.close();
    return boardList;
  }

  @Override
  public BoardDto getBoardById(Long id,String userId) {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    Board board = boardDAO.selectBoardById(id);
    Like isLiked = boardDAO.isLike(new Like(userId, board.getId()));

    BoardDto boardDTO = null;
    if (isLiked != null) {
      boardDTO = new BoardDto(board,true);
    }else{
      boardDTO = new BoardDto(board,false);
    }
    session.close();
    return boardDTO;
  }

  @Override
  public void createBoard(Board board) {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    boardDAO.insertBoard(board);
    session.commit();
    session.close();
  }

  @Override
  public void removeBoard(Long id) {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    boardDAO.deleteBoard(id);
    session.commit();
    session.close();
  }

  @Override
  public void updateBoard(Board board) {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    boardDAO.updateBoard(board);
    session.commit();
    session.close();
  }

  @Override
  public void updateCount(Long id) {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    boardDAO.updateCount(id);
    session.commit();
    session.close();
  }

  @Override
  public Boolean updateLike(Like like,Boolean liked) {
    SqlSession session = factory.openSession();
    boardDAO.setSession(session);
    Boolean bool = null;
    if(liked){
      boardDAO.deleteLike(like);
      bool = false;
    }else{
      boardDAO.insertLike(like);
      bool = true;
    }

    session.commit();
    session.close();
    return bool;
  }
}
