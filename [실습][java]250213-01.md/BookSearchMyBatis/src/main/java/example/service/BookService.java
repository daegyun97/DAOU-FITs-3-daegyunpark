package example.service;

import example.vo.BookVO;
import javafx.collections.ObservableList;

public interface BookService {

  ObservableList<BookVO> getBookByKeyWord(String keyWord);

  void updateBook(BookVO bookVO);

  void deleteBook(String bisbn);

  void registerBook(BookVO bookVO);
}
