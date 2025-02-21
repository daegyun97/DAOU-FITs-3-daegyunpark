package org.example.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.board.service.CommentService;
import org.example.board.service.CommentServiceImpl;

@WebServlet(value = "/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
  CommentService commentService = new CommentServiceImpl();
  public DeleteCommentServlet() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    commentService.removeComment((long) Integer.parseInt(req.getParameter("id")));
    // JSON 응답 설정
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write("{\"status\": \"success\"}");
  }

}

