<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
    
<!DOCTYPE html>
<html>
<head>
    <title>SignUp</title>
</head>
<body>

    <h2>Register</h2>
    <form action="SignUp_servlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password"id="password" name="password" required><br><br>
        <button type="submit">Sign UP</button>
    </form>
</body>