package servlets;

import beans.DriverBean;
import com.zaxxer.hikari.HikariDataSource;
import data.MyDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "MyServlet", urlPatterns = "/")
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter writer = response.getWriter();
//        writer.write("<html>"+
//                        "<head>"+
//                        "<title>Page</title>"+
//                        "</head>"+
//                        "<body>");
//
//        HikariDataSource dataSource = MyDataSource.getDataSource();
//        try (Connection connection = dataSource.getConnection()) {
//                PreparedStatement ps = connection.prepareStatement("select * from driver");
//                ResultSet rs = ps.executeQuery();
//                connection.close();
//                while (rs.next()) {
//                    int id = rs.getInt("id");
//                    String name = rs.getString("name");
//                    int truck_id = rs.getInt("id");
//                    writer.println(id + " " + name + " " + truck_id + "<br>");
//                }
//            writer.write("</body>" +
//                            "</html>");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        DriverBean driverBean = new DriverBean();
        request.setAttribute("driverBean", driverBean);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
