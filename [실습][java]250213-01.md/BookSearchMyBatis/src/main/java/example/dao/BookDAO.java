package example.dao;

import example.vo.BookVO;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public interface BookDAO {

  void setSession(SqlSession session);

  public BookVO duplicationCheck(String bisbn) throws Exception;

  public List<BookVO> selectByKeyWord(String keyWord) throws Exception;

  public void updateBook(BookVO bookVO) throws Exception;

  public void deleteByKey(String bisbn) throws Exception;

  public void insertBook(BookVO bookVO) throws Exception;

}
