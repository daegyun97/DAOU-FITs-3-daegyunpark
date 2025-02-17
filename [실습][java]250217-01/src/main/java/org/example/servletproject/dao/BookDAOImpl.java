package org.example.servletproject.dao;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.servletproject.dto.BookSearchDTO;
import org.example.servletproject.vo.Book;

public class BookDAOImpl implements BookDAO {

  private SqlSession sqlSession;

  public BookDAOImpl() {
  }
  public void setSession(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }
  @Override
  public List<Book> selectBooksByKeyword(BookSearchDTO bookSearchDTO) {
    return sqlSession.selectList("example.MyBook.selectByKeyWord", bookSearchDTO);
  }

  @Override
  public Book selectBookByIsbn(String isbn) {
    return sqlSession.selectOne("example.MyBook.selectByIsbn", isbn);
  }
}
