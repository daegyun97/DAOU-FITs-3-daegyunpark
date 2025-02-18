package org.example.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.board.service.UserService;
import org.example.board.service.UserServiceImpl;
import org.example.board.vo.Board;
import org.example.board.vo.User;


@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
  UserService userService = new UserServiceImpl();
  BoardService boardService = new BoardServiceImpl();
  public LoginServlet() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("doGet called");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //get parameter
    req.setCharacterEncoding("utf-8");
    String id = req.getParameter("id");
    String pw = req.getParameter("password");
    System.out.println("id: " + id + " pw: " + pw);
    User user = new User(id,pw);

    //service logic
    Boolean IsLogin = userService.getUserById(user);
    List<Board> boards = boardService.getAllBoars();
    for (Board board : boards) {
      System.out.println(board.getTitle());
    }


    //return response
    if(IsLogin) {
      RequestDispatcher rd = req.getRequestDispatcher("BoardJsp.jsp");
      req.setAttribute("boards", boards);
      rd.forward(req, resp);
    } else{
      resp.setContentType("text/html; charset=utf-8");
      PrintWriter out = resp.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html lang='en'>");
      out.println("<head><meta charset='UTF-8'><title>login 결과</title>");
      out.println("</head>");
      out.println("<body><h1>failed</h1>");
      out.println("</body></html>");
      out.flush();
      out.close();
    }

  }

  @Override
  public void destroy(){
    super.destroy();
    System.out.println("destroy called");
  }
}
