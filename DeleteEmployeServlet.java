package com.packages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM Employee WHERE EmployeeID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ps.executeUpdate();
            response.sendRedirect("listEmployees.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("listEmployees.jsp?error=Deletion failed");
        }
    }
}
