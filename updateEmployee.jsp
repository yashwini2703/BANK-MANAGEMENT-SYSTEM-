<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
    }
    String employeeId = request.getParameter("id");
%>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="text-center">Update Employee</h2>
    <form action="UpdateEmployeeServlet" method="post" class="w-50 mx-auto mt-4">
        <input type="hidden" name="employeeId" value="<%= employeeId %>">
        <div class="mb-3">
            <label class="form-label">First Name:</label>
            <input type="text" name="firstName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Last Name:</label>
            <input type="text" name="lastName" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Update Employee</button>
    </form>
</body>
</html>
