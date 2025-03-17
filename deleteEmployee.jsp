<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>
    <h2>Are you sure you want to delete this employee?</h2>
    <form action="DeleteEmployeeServlet" method="post">
        <input type="hidden" name="employeeId" value="<%= request.getParameter("id") %>">
        <button type="submit">Yes, Delete</button>
        <a href="dashboard.jsp">Cancel</a>
    </form>
</body>
</html>
