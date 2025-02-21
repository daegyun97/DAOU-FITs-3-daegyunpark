package org.example.board.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
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
import org.example.board.vo.Comment;
import org.example.board.vo.Like;
import org.example.board.vo.User;

@WebServlet(value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
  BoardService boardService= new BoardServiceImpl();
  public LikeServlet() {
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("init called");
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");

    Long boardId = Long.valueOf(req.getParameter("boardId"));
    Boolean isLike = Boolean.parseBoolean(req.getParameter("isLiked"));
    Like like = new Like(user.getId(),boardId);

    Boolean isLiked = boardService.updateLike(like,isLike);
    System.out.println(isLiked);
    System.out.println("==========================");
    // 댓글을 JSON 형태로 변환
    Gson gson = new Gson();
    String jsonComments = gson.toJson(isLiked);

    // 응답을 JSON 형식으로 보내기
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write(jsonComments);
  }

}
