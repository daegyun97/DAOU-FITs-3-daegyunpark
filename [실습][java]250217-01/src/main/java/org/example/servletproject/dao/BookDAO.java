package org.example.servletproject.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.servletproject.dto.BookSearchDTO;
import org.example.servletproject.vo.Book;

public interface BookDAO {
  void setSession(SqlSession session);

  List<Book> selectBooksByKeyword(BookSearchDTO bookSearchDTO);

  Book selectBookByIsbn(String isbn);
}
