package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inputfield2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    
    request.setCharacterEncoding("UTF-8");
    
    HttpSession hs = request.getSession();

    hs.setAttribute("Name", request.getParameter("name"));
    hs.setAttribute("Gender", request.getParameter("gender"));
    hs.setAttribute("Hobby", request.getParameter("hobby"));

    String Username = (String) hs.getAttribute("Name");
    String Usergender = (String) hs.getAttribute("Gender");
    String Userhobby = (String) hs.getAttribute("Hobby");
    
    String aaa = "";

    String bbb = "";

 

    if (hs.getAttribute("Gender") != null) {

        if (hs.getAttribute("Gender").equals("男性")) {

            aaa = "checked";

        }

        if (hs.getAttribute("Gender").equals("女性")) {

            bbb = "checked";

        }
        }
    
      out.write("\n");
      out.write("    \n");
      out.write("            <!DOCTYPE html>\n");
      out.write("<html\n");
      out.write("                    > <head>\n");
      out.write("                    < meta http - equiv = \"Content-Type\" content = \"text/html; charset=UTF-8\"\n");
      out.write("                    > <title>JSP Page</title\n");
      out.write("                    > < / head\n");
      out.write("                    > <body>\n");
      out.write("                    < form action = \"session2.jsp\" method = \"post\"\n");
      out.write("                    > 名前\n");
      out.write("            <input type = \"text\" name = \"name\" value = < % if (Username != null) {\n");
      out.write("                out.print(Username);\n");
      out.write("            } else {\n");
      out.write("                out.print(\"\");\n");
      out.write("            }%>><br><br> \n");
      out.write("\n");
      out.write("\n");
      out.write("性別<input type=\"radio\" name=\"gender\" value=\"男性\" ");
      out.print(aaa);
      out.write(">男性 \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<input type=\"radio\" name=\"gender\" value=\"女性\" ");
      out.print(bbb);
      out.write(">女性 \n");
      out.write("\n");
      out.write("<br><br>\n");
      out.write("\n");
      out.write("趣味を書いてください<br> \n");
      out.write("\n");
      out.write("<textarea name=\"hobby\" cols=\"50\" rows=\"10\">");
 if (Userhobby != null) {
        out.print(Userhobby);
    } else {
        out.print("");
    }
      out.write("</textarea><br><br> \n");
      out.write("\n");
      out.write("\n");
      out.write("<input type=\"checkbox\" name=\"check\">　次にアクセスした際に記録します<br><br> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<input type=\"submit\" name=\"btnSubmit\" value=\"送信\"> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<input type=\"reset\" name=\"rst\" value=\"リセット\"> \n");
      out.write("\n");
      out.write("\n");
      out.write("</form> \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
