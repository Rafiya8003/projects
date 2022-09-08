package com.register.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.register.bean.RegisterBean;
import com.register.dao.RegisterDao;
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public RegisterServlet() {
    super();
    // TODO Auto-generated constructor stub
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    System.out.println("inside post");
    response.setContentType("text/html");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String username = request.getParameter("uname");
    String password = request.getParameter("pass");
    RegisterBean bean = new RegisterBean(name, email, username, password);
    RegisterDao dao = new RegisterDao();
    String result = dao.Regiterindb(bean);
    if (result.equals("User is registered")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
      dispatcher.include(request, response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("Register.html");
      dispatcher.include(request, response);
    }
  }
}