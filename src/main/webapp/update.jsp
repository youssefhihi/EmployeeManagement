
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
</head>
<body>
<form id="updateForm" action="employee" method="post">
    <input type="hidden" name="_method" value="put" />

    <input type="hidden" name="employeeId" value="${employee.id}" />

    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" value="${employee.name}" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" value="${employee.email}" required><br><br>

    <label for="department">Department:</label><br>
    <input type="text" id="department" name="department" value="${employee.department}" required><br><br>

    <label for="phone">Phone:</label><br>
    <input type="text" id="phone" name="phone" value="${employee.phone}" required><br><br>

    <label for="post">Post:</label><br>
    <input type="text" id="post" name="post" value="${employee.post}" required><br><br>

    <button type="submit">Update Employee</button>
</form>
</body>
</html>
