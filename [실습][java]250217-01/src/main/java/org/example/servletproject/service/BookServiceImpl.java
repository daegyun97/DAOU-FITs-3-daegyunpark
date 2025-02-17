package org.example.servletproject.service;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.servletproject.dao.BookDAO;
import org.example.servletproject.dao.BookDAOImpl;
import org.example.servletproject.dto.BookSearchDTO;
import org.example.servletproject.vo.Book;

public class BookServiceImpl implements BookService {
  private SqlSessionFactory factory = MyBatisFactory.getSqlSessionFactory();
  private BookDAO bookDAO;

  public BookServiceImpl() {
    this.bookDAO = new BookDAOImpl();
  }

  @Override
  public List<Book> getBooksByKeyword(BookSearchDTO bookSearchDTO) {
    SqlSession session = factory.openSession();
    bookDAO.setSession(session);
    List<Book> books=bookDAO.selectBooksByKeyword(bookSearchDTO);
    session.close();
    return books;
  }

  @Override
  public Book getBookByIsbn(String isbn) {
    SqlSession session = factory.openSession();
    bookDAO.setSession(session);
    Book book=bookDAO.selectBookByIsbn(isbn);
    session.close();
    return book;
  }
}
