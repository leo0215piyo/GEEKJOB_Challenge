<%-- 
    Document   : cchallenge8-1
    Created on : 2017/07/21, 14:35:41
    Author     : leo_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
long total =1;     
for(int i = 0; i<20; i++){
 total = total * 8;
out.print(total);
out.print("<br>");
}


%>