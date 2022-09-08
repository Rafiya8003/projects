package com.login.LoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.login.DBconn.DBConnect;
import com.login.bean.LoginBean;
public class LoginDao {
  public boolean vaildate(LoginBean bean)
  {
    boolean result = false;
    Connection connection=DBConnect.getConn();
    String sql="select * from user_register where userName=? and password=?";
    try {
      PreparedStatement ps=connection.prepareStatement(sql);
      ps.setString(1, bean.getUserName());
      ps.setString(2, bean.getPassword());
      ResultSet rs=ps.executeQuery();
      result=rs.next();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }    
    return result;
  }
}