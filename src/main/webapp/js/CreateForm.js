const form = document.getElementById('employeeForm');
// inputs
const name = form.querySelector('#name');
const email = form.querySelector('#email');
const department = form.querySelector('#department');
const post = form.querySelector('#post');
const phone = form.querySelector('#phone');

// error msg elements
const nameError = form.querySelector('#nameValid');
const emailError = form.querySelector('#emailValid');
const phoneError = form.querySelector('#phoneValid');
const departmentError = form.querySelector('#departmentValid');
const postError = form.querySelector('#postValid');

// regex patterns
const nameRegex = /^[a-zA-Z0-9\s]{2,50}$/;
const emailRegex = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/;
const phoneRegex = /^[0-9]{10}$/;
const departmentRegex = /^[a-zA-Z\s]{2,50}$/;
const postRegex = /^[a-zA-Z\s]{2,50}$/;

form.addEventListener('submit', function (e) {
    e.preventDefault();
    console.log("hiiiiiiiiii");
    var isValid = true;

    // Validate name
    if (!nameRegex.test(name.value)) {
        nameError.style.display = 'block';
        name.style.border = '2px solid red';
        isValid = false;
    } else {
        nameError.style.display = 'none';
        name.style.border = '1px solid #ccc';
    }

    // Validate email
    if (!emailRegex.test(email.value)) {
        emailError.style.display = 'block';
        email.style.border = '2px solid red';
        isValid = false;
    } else {
        emailError.style.display = 'none';
        email.style.border = '1px solid #ccc';
    }

    // Validate phone
    if (!phoneRegex.test(phone.value)) {
        phoneError.style.display = 'block';
        phone.style.border = '2px solid red';
        isValid = false;
    } else {
        phoneError.style.display = 'none';
        phone.style.border = '1px solid #ccc';
    }

    // Validate department
    if (!departmentRegex.test(department.value)) {
        departmentError.style.display = 'block';
        department.style.border = '2px solid red';
        isValid = false;
    } else {
        departmentError.style.display = 'none';
        department.style.border = '1px solid #ccc';
    }

    // Validate post
    if (!postRegex.test(post.value)) {
        postError.style.display = 'block';
        post.style.border = '2px solid red';
        isValid = false;
    } else {
        postError.style.display = 'none';
        post.style.border = '1px solid #ccc';
    }

    if (isValid) {
        form.submit();
    }
});
