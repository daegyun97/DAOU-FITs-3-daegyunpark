package org.example.servletproject.service;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFactory {
  private static SqlSessionFactory sqlSessionFactory;

  static{
    try{
      String resource = "./SqlMapConfig.xml";
      Reader reader = Resources.getResourceAsReader(resource);
      if(sqlSessionFactory == null){
        sqlSessionFactory =
            new SqlSessionFactoryBuilder().build(reader);
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public static SqlSessionFactory getSqlSessionFactory(){
    return sqlSessionFactory;
  }

}
