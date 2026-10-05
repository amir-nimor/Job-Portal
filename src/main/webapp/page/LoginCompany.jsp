<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/4/2026
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Company</title>
</head>
<body>

<form action="/CompanyLoginServlet" method="post">

    <label>Username
        <input type="text" name="username" placeholder="Enter Username">
    </label>

    <label>Password
        <input type="password" name="password" placeholder="Enter Password">
    </label>

    <label>name
    <input type="text" name="name" />
    </label>

    <label>description>
    <input type="text" name="description" />
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

    <label>site
    <input type="text" name="site" placeholder="Enter Site">
    </label>

    <label>phoneNumber
    <input type="text" name="phoneNumber" placeholder="Enter Phone Number">
    </label>

    <button>Submit</button>

</form>

</body>
</html>
