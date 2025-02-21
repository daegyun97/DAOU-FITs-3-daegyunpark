package org.example.board.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.board.vo.Board;

@WebServlet(value = "/DeleteBoardServlet")
public class DeleteBoardServlet extends HttpServlet {
  BoardService boardService = new BoardServiceImpl();
  public DeleteBoardServlet() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    boardService.removeBoard((long) Integer.parseInt(req.getParameter("boardId")));
    // JSON 응답 설정
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write("{\"status\": \"success\"}");
  }

}
