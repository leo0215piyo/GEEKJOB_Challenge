<%-- 
    Document   : Challenge3-1
    Created on : 2017/07/20, 13:56:07
    Author     : leo_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 int num = 10;
  final int NUM = 5;
 
int tasu = num+NUM;

int hiku = num-NUM;

int kake = num*NUM;

int wari = num/NUM;

int amari = num%NUM;

out.print(tasu);
out.print(hiku);
out.print(kake);
out.print(wari);
out.print(amari);
 %>