package com.bitcamp.board.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;

@WebServlet(value="/init", loadOnStartup = 1)
public class AppInitServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public AppInitServlet() {
    ServletContext ctx = this.getServletContext();
  }

  @Override
  public void init() throws ServletException {
    System.out.println("공유 자원을 준비중!");
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","1111");

      ServletContext ctx = this.getServletContext();
      ctx.setAttribute("boardDao", new MariaDBBoardDao(con));
      ctx.setAttribute("memberDao", new MariaDBMemberDao(con));
    } catch (Exception e) {
      throw new ServletException();
    }
  }
}