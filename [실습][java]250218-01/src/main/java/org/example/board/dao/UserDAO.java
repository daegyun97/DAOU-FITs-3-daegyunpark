package org.example.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.board.vo.User;

public interface UserDAO {

  void setSession(SqlSession session);
  User selectUserById(String id);

}
