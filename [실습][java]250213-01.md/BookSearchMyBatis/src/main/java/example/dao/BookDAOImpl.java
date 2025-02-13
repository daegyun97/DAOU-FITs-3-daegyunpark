package example.dao;

import example.vo.BookVO;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class BookDAOImpl implements BookDAO {

  private SqlSession sqlSession;

  public BookDAOImpl() {
  }

  public void setSession(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  public List<BookVO> selectByKeyWord(String bisbn) throws Exception {
    List<BookVO> list = null;
    list = sqlSession.selectList("example.MyBook.selectByKeyWord", bisbn);
    return list;
  }

  public BookVO duplicationCheck(String bisbn) throws Exception {
    BookVO bookVO = null;
    bookVO = sqlSession.selectOne("example.MyBook.selectByISBN", bisbn);
    return bookVO;
  }

  public void updateBook(BookVO bookVO) throws Exception {
    sqlSession.update("example.MyBook.updateBook", bookVO);
  }

  public void deleteByKey(String bisbn) throws Exception {
    sqlSession.delete("example.MyBook.deleteBook", bisbn);
  }

  public void insertBook(BookVO bookVO) throws Exception {
    sqlSession.insert("example.MyBook.insertBook", bookVO);
  }

}


