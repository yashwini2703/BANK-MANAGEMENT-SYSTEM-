package com.packages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("id"));

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Employee WHERE EmployeeID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("employeeData", rs);
                response.sendRedirect("viewEmployee.jsp");
            } else {
                response.sendRedirect("listEmployees.jsp?error=Employee not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("listEmployees.jsp?error=Error fetching data");
        }
    }
}
