package com.packages;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String designation = request.getParameter("designation");
        String salary = request.getParameter("salary");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO Employee (FirstName, LastName, Email, ContactNumber, Designation, Salary) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, contact);
            ps.setString(5, designation);
            ps.setDouble(6, Double.parseDouble(salary));
            ps.executeUpdate();
            response.sendRedirect("listEmployees.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addEmployee.jsp?error=Error adding employee");
        }
    }
}
