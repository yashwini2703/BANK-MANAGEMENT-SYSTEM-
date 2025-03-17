<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="text-center">Admin Dashboard</h2>
    <div class="text-center">
        <a href="addEmployee.jsp" class="btn btn-success">Add Employee</a>
        <a href="listEmployees.jsp" class="btn btn-info">View Employees</a>
        <a href="LogoutServlet" class="btn btn-danger">Logout</a>
    </div>
</body>
</html>
