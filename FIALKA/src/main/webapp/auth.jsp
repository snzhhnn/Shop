<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop Authorization</title>
    <link rel="stylesheet" href="css/styles.css">
    <style>
        .error-message {
            color: white;
            background-color: #e74c3c;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 15px;
            text-align: center;
            font-weight: bold;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Login to Your Account</h2>

    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
    <p class="error-message">
        <%= errorMessage %>
    </p>
    <% } %>

    <form action="/FIALKA_war/login" method="GET">
        <div class="form-group">
            <label for="username">Username or Email</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <input type="submit" value="Login">
    </form>
    <div class="footer">
        <p>Don't have an account? <a href="/FIALKA_war/registration">Register here</a></p>
    </div>
</div>
</body>
</html>