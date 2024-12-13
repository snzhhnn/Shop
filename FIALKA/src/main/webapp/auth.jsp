<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login/Signup Form</title>
    <link rel="stylesheet" href="css/style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<div class="container">
    <div class="form-box login">
        <form action="/FIALKA_war/login" method="GET">
            <h1>Login</h1>
            <% String errorMessage;
                errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
            <p class="error-message">
                <%= errorMessage %>
            </p>
            <% } %>
            <div class="input-box">
                <input type="text" name="username" placeholder="Username" required>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="password" name="password" placeholder="Password" required>
                <i class='bx bxs-lock-alt' ></i>
            </div>
            <div class="forgot-link">
                <a href="#">Forgot Password?</a>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>
    </div>

    <div class="form-box register">
        <form action="/FIALKA_war/registration" method="POST">
            <h1>Registration</h1>
            <% errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
            <p class="error-message">
                <%= errorMessage %>
            </p>
            <% } %>
            <div class="input-box">
                <input type="text" name="lastname" placeholder="Lastname" required>
            </div>
            <div class="input-box">
                <input type="text" name="firstname" placeholder="Firstname" required>
            </div>
            <div class="input-box">
                <input type="text" name="surname" placeholder="Surname" required>
            </div>
            <div class="input-box">
                <input type="date" name="birthdate" placeholder="Birthdate" required>
            </div>
            <div class="input-box">
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div class="input-box">
                <input type="email" name="email" placeholder="Email" required>
            </div>
            <div class="input-box">
                <input type="password" name="password" placeholder="Password" required>
            </div>
            <div class="input-box">
                <input type="password" name="confirmPassword" placeholder="Confirm password" required>
            </div>
            <div class="input-box">
                <input type="text" name="phoneNumber" placeholder="Phone number" pattern="\+375(44|29|33|25)[0-9]{7}" required>
            </div>
            <div class="input-box">
                <input type="text" name="address" placeholder="Address" required>
            </div>
            <div class="input-box">
                <label for="gender">Gender</label>
                <div id="gender" class="radio-group">
                    <input type="radio" id="male" name="gender" value="male" required>
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="gender" value="female" required>
                    <label for="female">Female</label>
                </div>
            </div>
            <button type="submit" class="btn">Register</button>
        </form>
    </div>

    <div class="toggle-box">
        <div class="toggle-panel toggle-left">
            <h1>Hello, Welcome!</h1>
            <p>Don't have an account?</p>
            <button class="btn register-btn">Register</button>
        </div>

        <div class="toggle-panel toggle-right">
            <h1>Welcome Back!</h1>
            <p>Already have an account?</p>
            <button class="btn login-btn">Login</button>
        </div>
    </div>
</div>

<script src="js/main.js"></script>
</body>
</html>