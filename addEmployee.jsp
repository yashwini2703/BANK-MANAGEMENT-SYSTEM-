<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="text-center">Add Employee</h2>
    <form action="AddEmployeeServlet" method="post" class="w-50 mx-auto mt-4">
        <div class="mb-3">
            <label class="form-label">First Name:</label>
            <input type="text" name="firstName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Last Name:</label>
            <input type="text" name="lastName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Contact Number:</label>
            <input type="text" name="contact" class="form-control" pattern="\d{10}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Designation:</label>
            <input type="text" name="designation" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Salary:</label>
            <input type="number" name="salary" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success w-100">Add Employee</button>
    </form>
</body>
</html>
