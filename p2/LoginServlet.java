package com.login.Servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.login.LoginDao.LoginDao;
import com.login.bean.LoginBean;
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
      response.setContentType("text/html");
      String uname=request.getParameter("uname");
      String pass=request.getParameter("pass");
      LoginBean bean=new LoginBean();
      LoginDao dao=new LoginDao();
      bean.setUserName(uname);
      bean.setPassword(pass);
      if(dao.vaildate(bean))
      {
        response.sendRedirect("Welcome.html");
      }
      else
      {
        response.sendRedirect("Login.html");
      }
  }
}