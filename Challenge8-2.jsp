<%-- 
    Document   : Challenge8-2
    Created on : 2017/07/24, 11:07:47
    Author     : leo_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
   int num = 1000;
   int time = 0;
    
   while(num >=100){
      
    time--;
       num = num / 2;
   }
   out.print(time);
   
%>