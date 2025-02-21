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
import org.example.board.dto.BoardsDTO;
import org.example.board.dto.CommentDTO;
import org.example.board.mybatis.MyBatisFactory;
import org.example.board.vo.Board;
import org.example.board.vo.Comment;

public class CommentServiceImpl implements CommentService {
  CommentDAO commentDAO;
  UserDAO userDAO;
  private SqlSessionFactory factory = MyBatisFactory.getSqlSessionFactory();

  public CommentServiceImpl() {

    this.commentDAO = new CommentDAOImpl();
    this.userDAO = new UserDAOImpl();
  }


  @Override
  public List<CommentDTO> getComments(Long id) {
    SqlSession session = factory.openSession();
    commentDAO.setSession(session);
    userDAO.setSession(session);
    List<CommentDTO> commentList = new ArrayList<>();
    List<Comment> comments = commentDAO.selectCommentById(id);
    if (comments != null) {
      for (Comment comment : comments) {
        String name = userDAO.selectUserById(comment.getAuthor()).getName();
        commentList.add(new CommentDTO(comment,name));
      }
    }
    session.close();
    return commentList;
  }

  @Override
  public void createComment(Comment comment) {
    SqlSession session = factory.openSession();
    commentDAO.setSession(session);
    commentDAO.insertComment(comment);
    session.commit();
    session.close();
  }

  @Override
  public void removeComment(Long id) {
    SqlSession session = factory.openSession();
    commentDAO.setSession(session);
    commentDAO.deleteComment(id);
    session.commit();
    session.close();
  }
}
