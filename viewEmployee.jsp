<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>View Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="text-center">Employee Details</h2>
    <div class="card p-4">
        <p><strong>First Name:</strong> John</p>
        <p><strong>Last Name:</strong> Doe</p>
        <p><strong>Email:</strong> johndoe@example.com</p>
        <a href="dashboard.jsp" class="btn btn-primary">Back to Dashboard</a>
    </div>
</body>
</html>
