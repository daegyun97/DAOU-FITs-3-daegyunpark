package org.example.servletproject.service;

import java.util.List;
import org.example.servletproject.dto.BookSearchDTO;
import org.example.servletproject.vo.Book;

public interface BookService {
  List<Book> getBooksByKeyword(BookSearchDTO bookSearchDTO);

  Book  getBookByIsbn(String isbn);

}
