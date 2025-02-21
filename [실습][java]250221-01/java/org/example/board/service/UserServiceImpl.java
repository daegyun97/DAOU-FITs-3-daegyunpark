package org.example.board.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.board.dao.UserDAO;
import org.example.board.dao.UserDAOImpl;
import org.example.board.exception.CustomException;
import org.example.board.exception.ErrorCode;
import org.example.board.mybatis.MyBatisFactory;
import org.example.board.vo.User;

public class UserServiceImpl implements UserService {
  UserDAO userDAO;
  private SqlSessionFactory factory = MyBatisFactory.getSqlSessionFactory();

  public UserServiceImpl() {
    this.userDAO = new UserDAOImpl();
  }

  @Override
  public User getUserById(User user) {
    SqlSession session = factory.openSession();
    userDAO.setSession(session);
    User selectedUser = userDAO.selectUserById(user.getId());
    session.close();
    if(selectedUser == null) {
      throw new CustomException(ErrorCode.USER_NOT_FOUND);
    }else if(!user.getPassword().equals(selectedUser.getPassword())) {
      throw new CustomException(ErrorCode.INVALID_PASSWORD);
    }

    return selectedUser;
  }

}
