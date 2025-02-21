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
import javax.servlet.http.HttpSession;
import org.example.board.dto.BoardsDTO;
import org.example.board.exception.CustomException;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.board.service.UserService;
import org.example.board.service.UserServiceImpl;
import org.example.board.vo.User;

@WebServlet(value = "/BoardListServlet")
public class BoardListServlet extends HttpServlet {
  UserService userService = new UserServiceImpl();
  BoardService boardService = new BoardServiceImpl();
  public BoardListServlet() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String keyword = req.getParameter("keyWord");
    if (keyword == null) {
      keyword = "";
    }
    List<BoardsDTO> boards = boardService.getAllBoars(keyword);
    HttpSession session = req.getSession();


    User user = (User) session.getAttribute("user");
//    System.out.println(user.getName());
    RequestDispatcher rd = req.getRequestDispatcher("BoardJsp.jsp");
    req.setAttribute("boards", boards);
    req.setAttribute("userName", user.getName());
    rd.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

  }

  @Override
  public void destroy(){
    super.destroy();
    System.out.println("destroy called");
  }
}
