<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/1/2026
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="/LoginUser" method="post">

    <label>Username
    <input type="text" name="username" placeholder="Enter Username">
    </label>

    <label>Password
    <input type="password" name="password" placeholder="Enter Password">
    </label>

    <label>fullname
    <input type="text" name="fullname" placeholder="Enter Fullname">
    </label>

    <label>phonenumber
    <input type="text" name="phonenumber" placeholder="Enter Phonenumber">
    </label>

    <label>city
    <input type="text" name="city" placeholder="Enter City">
    </label>

    <label>street
    <input type="text" name="street" placeholder="Enter Street">
    </label>

    <label>zipcode
    <input type="text" name="zipcode" placeholder="Enter Zipcode">
    </label>

    <label>workMonth
    <input type="number" name="workMonth" placeholder="Enter WorkMonth">
    </label>

    <label>resume
    <input type="text" name="resume" placeholder="Enter Resume">
    </label>

    <label>description
    <input type="text" name="description" placeholder="Enter Description">
    </label>

    <button>Login</button>

</form>

</body>
</html>
