package org.example.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.board.vo.User;

public class UserDAOImpl implements UserDAO {
  private SqlSession sqlSession;

  public UserDAOImpl() {
  }
  public void setSession(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public User selectUserById(String id) {
    return sqlSession.selectOne("example.MyUser.selectById", id);
  }

}
