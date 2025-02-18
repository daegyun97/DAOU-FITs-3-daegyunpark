package org.example.board.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.board.dao.UserDAO;
import org.example.board.dao.UserDAOImpl;
import org.example.board.mybatis.MyBatisFactory;
import org.example.board.vo.User;

public class UserServiceImpl implements UserService {
  UserDAO userDAO;
  private SqlSessionFactory factory = MyBatisFactory.getSqlSessionFactory();

  public UserServiceImpl() {
    this.userDAO = new UserDAOImpl();
  }

  @Override
  public Boolean getUserById(User user) {
    SqlSession session = factory.openSession();
    userDAO.setSession(session);
    User selectedUser = userDAO.selectUserById(user.getId());
    session.close();
    if(selectedUser == null) {
      return false;
    }else if(!user.getPassword().equals(selectedUser.getPassword())) {
      return false;
    }
    System.out.println(selectedUser.getName());

    return true;
  }

}
