<%-- 
    Document   : Challenge5-6
    Created on : 2017/07/21, 11:11:49
    Author     : leo_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    char moji = 'あ';
    
    switch(moji) {
    case 'A':
    out.print("英語");
    break;
    case 'あ':
    out.print("日本語");
    break;
    default:
    break;
    
}
%>