package example.service;

import example.dao.BookDAO;
import example.dao.BookDAOImpl;
import example.mybatis.MyBatisSessionFactory;
import example.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BookServiceImpl implements BookService {

  private SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
  private BookDAO bookDAO;

  public BookServiceImpl() {
    this.bookDAO = new BookDAOImpl();
  }

  @Override
  public ObservableList<BookVO> getBookByKeyWord(String keyWord) {
    ObservableList<BookVO> books = null;
    SqlSession session = factory.openSession();
    try {
      bookDAO.setSession(session);
      books = FXCollections.observableArrayList(bookDAO.selectByKeyWord("%" + keyWord + "%"));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return books;
  }

  @Override
  public void updateBook(BookVO bookVO) {
    SqlSession session = factory.openSession();
    try {
      bookDAO.setSession(session);
      bookDAO.updateBook(bookVO);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
      session.rollback();
    } finally {
      session.close();
    }
  }

  @Override
  public void deleteBook(String bisbn) {
    SqlSession session = factory.openSession();
    try {
      bookDAO.setSession(session);
      bookDAO.deleteByKey(bisbn);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public void registerBook(BookVO bookVO) {
    SqlSession session = factory.openSession();
    try {
      bookDAO.setSession(session);
      BookVO selectedBook = bookDAO.duplicationCheck(bookVO.getBisbn());
      if (selectedBook != null) {
        throw new IllegalStateException("이미 존재하는 BISBN입니다");
      }
      bookDAO.insertBook(bookVO);
      session.commit();
    } catch (IllegalStateException e) {
      throw new IllegalStateException("이미 존재하는 BISBN입니다");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
  }
}



