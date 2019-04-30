<%-- 
    Document   : sqltest
    Created on : Apr 30, 2019, 7:11:06 PM
    Author     : User
--%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","","");
          out.println(conn);
          conn.close();
        %>
    </body>
</html>
