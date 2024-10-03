
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/update.css">
</head>
<body>
<form id="updateForm" action="${pageContext.request.contextPath}/employees" method="post">
    <input type="hidden" name="method" value="update" />
     <input value="${employee.getId()}" name="id" type="hidden">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${employee.getName()}" >
    <span id="nameValid" style="color: red; display: none;">Please enter a valid name .</span><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email"  value="${employee.getEmail()}" >
    <span id="emailValid" style="color: red; display: none;">Please enter a valid email.</span><br><br>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department"  value="${employee.getDepartment()}">
    <span id="departmentValid" style="color: red; display: none;">Please enter a valid department name.</span><br><br>

    <label for="phone">Phone:</label>
    <input type="tel" id="phone" name="phone"  value="${employee.getPhone()}">
    <span id="phoneValid" style="color: red; display: none;">Please enter a valid phone number .</span><br><br>

    <label for="post">Post:</label>
    <input type="text" id="post" name="post"  value="${employee.getPost()}">
    <span id="postValid" style="color: red; display: none;">Please enter a valid post.</span><br><br>

    <input type="submit" value="Add Employee">
</form>
<script src="${pageContext.request.contextPath}/js/UpdateForm.js"></script>
</body>
</html>
