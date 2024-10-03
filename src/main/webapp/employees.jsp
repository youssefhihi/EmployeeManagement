
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
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
    <div class="">
            <c:forEach var="error" items="${errors}">
                <div class="popup error-popup">
                    <div class="popup-icon error-icon">
                        <svg
                                class="error-svg"
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 20 20"
                                aria-hidden="true"
                        >
                            <path
                                    fill-rule="evenodd"
                                    d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z"
                                    clip-rule="evenodd"
                            ></path>
                        </svg>
                    </div>
                    <div class="error-message">${error}</div>
                    <div class="popup-icon close-icon">
                        <svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 20 20"
                                class="close-svg"
                        >
                            <path
                                    d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z"
                                    class="close-path"
                            ></path>
                        </svg>
                    </div>
                </div>
            </c:forEach>
    </div>
</c:if>
<button id="showFormButton">Show Form</button>

<div class="search-container">
    <input type="search" placeholder="Search..." class="search-input" />
    <button class="search-button">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
            <path d="M10 2a8 8 0 1 0 6.32 13.32l4.16 4.16a1 1 0 0 0 1.41-1.41l-4.16-4.16A8 8 0 0 0 10 2zm0 2a6 6 0 1 1 0 12A6 6 0 0 1 10 4z"/>
        </svg>
    </button>
</div>

<div class="container">
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Name  </div>
            <div class="col col-2">  Email</div>
            <div class="col col-3">Department</div>
            <div class="col col-4">Phone</div>
            <div class="col col-4">Post</div>
            <div class="col col-4">Operations</div>
        </li>
        <c:forEach var="employee" items="${employees}">
        <li class="table-row">
            <div class="col col-1" data-label="name">${employee.getName()}</div>
            <div class="col col-2" data-label="email">${employee.getEmail()}</div>
            <div class="col col-3" data-label="department">${employee.getDepartment()}</div>
            <div class="col col-4" data-label="phone">${employee.getPhone()}</div>
            <div class="col col-5" data-label="post">${employee.getPost()}</div>
            <div class="col col-5 operations" data-label="operations">
                <form class="deleteForm" action="${pageContext.request.contextPath}/employees" method="post">
                    <input type="hidden" name="method" value="delete" />
                    <input type="hidden" name="id" value="${employee.getId()}" />
                    <button type="submit" class="delete-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 30 30">
                            <path d="M 14.984375 2.4863281 A 1.0001 1.0001 0 0 0 14 3.5 L 14 4 L 8.5 4 A 1.0001 1.0001 0 0 0 7.4863281 5 L 6 5 A 1.0001 1.0001 0 1 0 6 7 L 24 7 A 1.0001 1.0001 0 1 0 24 5 L 22.513672 5 A 1.0001 1.0001 0 0 0 21.5 4 L 16 4 L 16 3.5 A 1.0001 1.0001 0 0 0 14.984375 2.4863281 z M 6 9 L 7.7929688 24.234375 C 7.9109687 25.241375 8.7633438 26 9.7773438 26 L 20.222656 26 C 21.236656 26 22.088031 25.241375 22.207031 24.234375 L 24 9 L 6 9 z"></path>
                        </svg>
                    </button>
                </form>
                <a href="${pageContext.request.contextPath}/employees/edit?id=${employee.getId()}" class="edit-icon">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 128 128">
                        <path d="M 79.335938 15.667969 C 78.064453 15.622266 76.775 15.762109 75.5 16.099609 C 72.1 16.999609 69.299609 19.199219 67.599609 22.199219 L 64 28.699219 C 63.2 30.099219 63.699609 32.000781 65.099609 32.800781 L 82.400391 42.800781 C 82.900391 43.100781 83.400391 43.199219 83.900391 43.199219 C 84.200391 43.199219 84.399219 43.199609 84.699219 43.099609 C 85.499219 42.899609 86.1 42.399219 86.5 41.699219 L 90.199219 35.199219 C 91.899219 32.199219 92.4 28.700781 91.5 25.300781 C 90.6 21.900781 88.400391 19.100391 85.400391 17.400391 C 83.525391 16.337891 81.455078 15.744141 79.335938 15.667969 z M 60.097656 38.126953 C 59.128906 38.201172 58.199219 38.724609 57.699219 39.599609 L 27.5 92 C 24.1 97.8 22.200781 104.30039 21.800781 110.90039 L 21 123.80078 C 20.9 124.90078 21.5 125.99961 22.5 126.59961 C 23 126.89961 23.5 127 24 127 C 24.6 127 25.199219 126.8 25.699219 126.5 L 36.5 119.40039 C 42 115.70039 46.7 110.8 50 105 L 80.300781 52.599609 C 81.100781 51.199609 80.599219 49.3 79.199219 48.5 C 77.799219 47.7 75.899609 48.199609 75.099609 49.599609 L 44.800781 102 C 41.900781 106.9 37.899609 111.20039 33.099609 114.40039 L 27.300781 118.19922 L 27.699219 111.30078 C 27.999219 105.60078 29.699609 100 32.599609 95 L 62.900391 42.599609 C 63.700391 41.199609 63.200781 39.3 61.800781 38.5 C 61.275781 38.2 60.678906 38.082422 60.097656 38.126953 z M 49 121 C 47.3 121 46 122.3 46 124 C 46 125.7 47.3 127 49 127 L 89 127 C 90.7 127 92 125.7 92 124 C 92 122.3 90.7 121 89 121 L 49 121 z M 104 121 A 3 3 0 0 0 101 124 A 3 3 0 0 0 104 127 A 3 3 0 0 0 107 124 A 3 3 0 0 0 104 121 z"></path>
                    </svg>
                </a>
            </div>
        </li>
        </c:forEach>
    </ul>
</div>

<form id="employeeForm" action="${pageContext.request.contextPath}/employees" method="post">
    <input type="hidden" name="method" value="post" />

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
    const closeIcons = document.getElementsByClassName("close-icon");
    for (let i = 0; i < closeIcons.length; i++) {
        closeIcons[i].onclick = function() {
            const popup = this.closest(".popup");
            if (popup) {
                popup.remove();
            }
        };
    }
</script>
<script src="js/CreateForm.js"></script>
</body>
</html>