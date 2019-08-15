<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Maven, Good <% if (new GregorianCalendar().get(Calendar.HOUR_OF_DAY) < 12) {%>
    Morning
    <% } else { %>
    Afternoon
    <% } %></h1>
</body>
</html>