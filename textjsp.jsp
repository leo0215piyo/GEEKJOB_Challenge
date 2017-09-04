<%-- 
    Document   : textjsp
    Created on : 2017/09/04, 10:43:37
    Author     : leo_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
   request.setCharacterEncoding("UTF-8");
   out.print(request.getParameter("Name"));
   out.print(request.getParameter("gender"));
   out.print(request.getParameter("hobbytext"));
    %>
    </body>
</html>
