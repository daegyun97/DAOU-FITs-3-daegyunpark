package org.example.servletproject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.servletproject.service.BookService;
import org.example.servletproject.service.BookServiceImpl;
import org.example.servletproject.vo.Book;

@WebServlet(value = "/BookDetailPage")
public class BookDetailPage extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private BookService bookService = new BookServiceImpl();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, IOException {
    // URL 파라미터에서 ISBN 값 가져오기
    String isbn = request.getParameter("isbn");

    // ISBN을 기반으로 책 정보 조회
    Book book = bookService.getBookByIsbn(isbn);

    // HTML 형식으로 결과 페이지 출력
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    if (book != null) {
      out.println("<!DOCTYPE html>");
      out.println("<html lang='en'>");
      out.println("<head><meta charset='UTF-8'><title>도서 상세 정보</title></head>");
      out.println("<body><h1>도서 상세 정보</h1>");
      out.println("<table border='1'><tr><th>ISBN</th><td>" + book.getBisbn() + "</td></tr>");
      out.println("<tr><th>도서명</th><td>" + book.getBtitle() + "</td></tr>");
      out.println("<tr><th>가격</th><td>" + book.getBprice() + "원</td></tr>");
      out.println("<tr><th>저자</th><td>" + book.getBauthor() + "원</td></tr>");
      out.println("</table>");
      out.println("<a href='BookSearchResults?keyWord=" + request.getParameter("keyWord") + "'>검색 결과로 돌아가기</a>");
      out.println("</body></html>");
    } else {
      out.println("<h2>책 정보를 찾을 수 없습니다.</h2>");
    }
  }
}
