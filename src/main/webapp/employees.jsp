
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/validateForm.js"></script></head>
<body>
<!-- Display success message -->
<c:if test="${not empty success}">
    <div class="popup success-popup">
        <div class="popup-icon success-icon">
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 24 24"
                    class="success-svg"
            >
                <path
                        fill-rule="evenodd"
                        d="m12 1c-6.075 0-11 4.925-11 11s4.925 11 11 11 11-4.925 11-11-4.925-11-11-11zm4.768 9.14c.0878-.1004.1546-.21726.1966-.34383.0419-.12657.0581-.26026.0477-.39319-.0105-.13293-.0475-.26242-.1087-.38085-.0613-.11844-.1456-.22342-.2481-.30879-.1024-.08536-.2209-.14938-.3484-.18828s-.2616-.0519-.3942-.03823c-.1327.01366-.2612.05372-.3782.1178-.1169.06409-.2198.15091-.3027.25537l-4.3 5.159-2.225-2.226c-.1886-.1822-.4412-.283-.7034-.2807s-.51301.1075-.69842.2929-.29058.4362-.29285.6984c-.00228.2622.09851.5148.28067.7034l3 3c.0983.0982.2159.1748.3454.2251.1295.0502.2681.0729.4069.0665.1387-.0063.2747-.0414.3991-.1032.1244-.0617.2347-.1487.3236-.2554z"
                        clip-rule="evenodd"
                ></path>
            </svg>
        </div>
        <div class="success-message">${success}</div>
        <div class="popup-icon close-icon">
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 20 20"
                    aria-hidden="true"
                    class="close-svg"
            >
                <path
                        d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z"
                        class="close-path"
                ></path>
            </svg>
        </div>
    </div>
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
<table id="employeeTable">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Phone</th>
        <th>Post</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.getName()}</td>
            <td>${employee.email}</td>
            <td>${employee.department}</td>
            <td>${employee.phone}</td>
            <td>${employee.post}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form id="employeeForm" action="${pageContext.request.contextPath}/employees" method="post">
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
    const closeIcon = document.getElementsByClassName("close-icon")[0];
    closeIcon.onclick = function() {
         document.getElementsByClassName("popup")[0].remove();
    };
</script>
</body>
</html>