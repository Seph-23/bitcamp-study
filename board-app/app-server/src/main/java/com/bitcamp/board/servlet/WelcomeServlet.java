package com.bitcamp.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/welcome")
public class WelcomeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html; charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>환영합니다!</h1>");
    out.println("<p>비트캠프 게시판 관리 시스템 프로젝트입니다.</p>");
    out.println("<ul>");
    out.println("  <li><a href='board/list'>게시글</a></li>");
    out.println("  <li><a href='member/list'>회원</a></li>");
    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");
  }
}
