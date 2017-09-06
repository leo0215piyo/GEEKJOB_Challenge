<%-- 
    Document   : Qr
    Created on : 2017/09/04, 16:12:51
    Author     : leo_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test.jsp</title>
    </head>
    <body>
        <%

            request.setCharacterEncoding("UTF-8");

            String a = request.getParameter("total");
            String b = request.getParameter("count");
            String c = request.getParameter("type");

            int d = Integer.parseInt(a);
            int e = Integer.parseInt(b);
            int type = Integer.parseInt(c);

            int f = d / e;

            switch (type) {

                case 1:
                    out.print("雑貨");
                    break;
                case 2:
                    out.print("生鮮食品");
                    break;
                case 3:
                    out.print("その他");
                    break;

            }
            out.print("は" + f + "円 <br>");

if(d > 5000){
   int p = (int) (d * 0.05);
   
           out.print("p + ポイントつきました！");
}
else if (d > 3000){
     out.print("p + ポイントつきました！");
}else{
     out.print("今回はポイントつきません");
}
    
%>
    </body>
</html>
