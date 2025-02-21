package org.example.board.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.example.board.dto.CommentDTO;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.board.service.CommentService;
import org.example.board.service.CommentServiceImpl;
import org.example.board.vo.Board;
import org.example.board.vo.Comment;
import org.example.board.vo.User;

@WebServlet(value = "/CommentServlet")
public class CommentServlet extends HttpServlet {
  CommentService commentService= new CommentServiceImpl();
  public CommentServlet() {
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

    String boardIdParam = req.getParameter("boardId");
    if (boardIdParam == null || boardIdParam.isEmpty()) {
      System.out.println("boardIdParam is null or empty");
      return;
    }
    Long boardId = Long.parseLong(boardIdParam);
    List<CommentDTO> comments =commentService.getComments(boardId);

    // 댓글을 JSON 형태로 변환
    Gson gson = new Gson();
    String jsonComments = gson.toJson(comments);

    // 응답을 JSON 형식으로 보내기
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write(jsonComments);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");

    String commentContent = req.getParameter("content");
    Long boardId = Long.parseLong(req.getParameter("boardId"));
    Comment comment = new Comment(boardId,commentContent, user.getId());

    commentService.createComment(comment);

    // 댓글을 JSON 형태로 변환
    Gson gson = new Gson();
    String jsonComments = gson.toJson(comment);
    // 응답을 JSON 형식으로 보내기
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write(jsonComments);
    System.out.println("여기까지 오나?");
  }

}
