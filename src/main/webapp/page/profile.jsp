<%@ page import="ir.maktabsharif.model.User" %>
<%@ page import="ir.maktabsharif.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/4/2026
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profile</title>
</head>
<body>

<%
    String rols = (String) request.getAttribute("rols");
    System.out.println(rols);
%>


<%if (rols.equals("user")){%>
<li>${user}</li>
<%}%>





<%if (rols.equals("company")){%>
<li>${company}</li>
<%}%>




</body>
</html>
