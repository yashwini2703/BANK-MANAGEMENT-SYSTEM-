package com.packages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE Employee SET FirstName=?, LastName=? WHERE EmployeeID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, employeeId);
            ps.executeUpdate();
            response.sendRedirect("listEmployees.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("updateEmployee.jsp?error=Update failed&id=" + employeeId);
        }
    }
}

