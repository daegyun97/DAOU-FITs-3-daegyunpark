package org.example.servletproject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/myServlet")
public class MyFisrtServlet extends HttpServlet {
  public MyFisrtServlet() {
    System.out.println("constructor called");
  }

  @Override
  public void init() throws ServletException{
    super.init();
    System.out.println("init called");
  }

//  @Override
//  public void service(HttpServletRequest req, HttpServletResponse resp)
//      throws ServletException, IOException {
//    //일반적으로 오버라이딩 하지 않음
//    super.service(req,resp);
//  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //get parameter
    req.setCharacterEncoding("utf-8");
    String name = req.getParameter("keyWord");
    String age = req.getParameter("price");

    //service logic

    //return response
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head></head>");
    out.println("<body>"+name+", "+age+ "</body>");
    out.println("</html>");
    out.flush();
    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //get parameter
    req.setCharacterEncoding("utf-8");
    String name = req.getParameter("name");
    String age = req.getParameter("age");

    //service logic


    //return response
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head></head>");
    out.println("<body>"+name+", "+age+ "</body>");
    out.println("</html>");
    out.flush();
    out.close();
  }

  @Override
  public void destroy(){
    super.destroy();
    System.out.println("destroy called");
  }



}
