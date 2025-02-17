package org.example.servletproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.servletproject.dto.BookSearchDTO;
import org.example.servletproject.service.BookService;
import org.example.servletproject.service.BookServiceImpl;
import org.example.servletproject.vo.Book;

@WebServlet(value = "/BookController")
public class BookController extends HttpServlet {
  BookService bookService = new BookServiceImpl();
  public BookController() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //get parameter
    req.setCharacterEncoding("utf-8");
    String keyword = req.getParameter("keyWord");
    String price = req.getParameter("price");
    BookSearchDTO bookSearchDTO = new BookSearchDTO("%"+keyword+"%",Integer.parseInt(price));

    //service logic
    List<Book> books = bookService.getBooksByKeyword(bookSearchDTO);


    //return response
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head><meta charset='UTF-8'><title>도서검색 결과</title>");
    out.println("<script>");
    out.println("function handleRowClick(isbn) {");
    out.println("  // ISBN을 새로운 페이지로 전달");
    out.println("  window.location.href = 'BookDetailPage?isbn=' + isbn;");
    out.println("}");
    out.println("</script>");
    out.println("</head>");
    out.println("<body><h1>도서검색 결과</h1>");
    out.println("<table border='1'><thead><tr><th>도서명</th><th>가격</th></tr></thead><tbody>");

    // 책 목록을 반복문으로 테이블에 동적으로 삽입
    for (Book book : books) {
      out.println("<tr onclick='handleRowClick(\"" + book.getBisbn() + "\")'>");
      out.println("<td>" + book.getBtitle() + "</td>");
      out.println("<td>" + book.getBprice() + "원</td>");
      out.println("</tr>");
    }

    out.println("</tbody></table>");
    out.println("</body></html>");
    out.flush();
    out.close();


  }

  @Override
  public void destroy(){
    super.destroy();
    System.out.println("destroy called");
  }
}
