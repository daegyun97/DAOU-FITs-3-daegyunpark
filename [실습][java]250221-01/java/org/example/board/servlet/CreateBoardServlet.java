package org.example.board.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.example.board.dto.BoardsDTO;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.board.vo.Board;
import org.example.board.vo.User;

@WebServlet(value = "/CreateBoardServlet")
public class CreateBoardServlet extends HttpServlet {
  BoardService boardService = new BoardServiceImpl();
  public CreateBoardServlet() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    RequestDispatcher rd = req.getRequestDispatcher("CreateBoard.jsp");
    rd.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
    Board board = new Board(req.getParameter("title"),
        req.getParameter("content"),
        LocalDateTime.now(), user.getName()
    );

    boardService.createBoard(board);
    List<BoardsDTO> boards = boardService.getAllBoars("");

    RequestDispatcher rd = req.getRequestDispatcher("BoardJsp.jsp");
    req.setAttribute("boards", boards);
    rd.forward(req, resp);
  }

}
