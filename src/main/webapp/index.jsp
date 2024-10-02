<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- Display success message -->
<c:if test="${not empty success}">
    <div class="success">${success}</div>
</c:if>

<!-- Display error messages -->
<c:if test="${not empty errors}">
    <div class="error">
        <ul>
            <c:forEach var="error" items="${errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>
<button id="showFormButton">Show Form</button>
<form id="employeeForm" action="${pageContext.request.contextPath}/employees/add" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" >
    <span id="nameValid" style="color: red; display: none;">Please enter a valid name (3-50 characters).</span><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" >
    <span id="emailValid" style="color: red; display: none;">Please enter a valid email.</span><br><br>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department" >
    <span id="departmentValid" style="color: red; display: none;">Please enter a valid department name (3-50 characters).</span><br><br>

    <label for="phone">Phone:</label>
    <input type="tel" id="phone" name="phone" >
    <span id="phoneValid" style="color: red; display: none;">Please enter a valid phone number (10 digits).</span><br><br>

    <label for="post">Post:</label>
    <input type="text" id="post" name="post" >
    <span id="postValid" style="color: red; display: none;">Please enter a valid post (3-50 characters).</span><br><br>

    <input type="submit" value="Add Employee">
</form>

<script>
    document.getElementById("showFormButton").onclick = function() {
        var form = document.getElementById("employeeForm");
        form.classList.toggle("center");
    };
</script>
<script src="js/validateForm.js"></script>
</body>
</html>