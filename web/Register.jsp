<%-- 
    Document   : Register
    Created on : Oct 26, 2023, 11:03:52 PM
    Author     : ryanz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Now</title>
    </head>
    <body>
        
        <h1>Register</h1>
        <form action="Public" method="POST">
            ${errorMessage}
            <input type="hidden" name="action" value="register">
            <div>
            <label>Username: </label>
            <input type="Text" name="username"><br/>
            </div>
            <div>
            <label>First Name: </label>
            <input type="Text" name="firstname"><br/>
            </div>
            <div>
            <label>Last Name: </label>
            <input type="Text" name="lastname"><br/>
            </div>
            <div>
            <label>Email: </label>
            <input type="Text" name="email"><br/>
            </div>
            <div>
            <label>Password: </label>
            <input type="Text" name="password"><br/>
            </div>
            <input type="submit" value="Register">
        </form>
        
    </body>
</html>
