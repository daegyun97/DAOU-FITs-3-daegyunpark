package org.example.board.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.example.board.dto.BoardDto;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.board.vo.Board;
import org.example.board.vo.User;

@WebServlet(value = "/BoardDetailServlet")
public class BoardDetailServlet extends HttpServlet {
  BoardService boardService = new BoardServiceImpl();
  public BoardDetailServlet() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");

    BoardDto board = boardService.getBoardById((long) Integer.parseInt(req.getParameter("id")),user.getId());

    RequestDispatcher rd = req.getRequestDispatcher("boardDetail.jsp");
    req.setAttribute("board", board);
    req.setAttribute("name", user.getName());
    rd.forward(req, resp);
  }

}
