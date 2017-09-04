package modoriti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leo_e
 */
public class hikisuumodoriti3 extends HttpServlet {

 ArrayList<Integer> id = new ArrayList<Integer>();
 
 ArrayList<String> namae = new ArrayList<String>();
 
 ArrayList<String> btd = new ArrayList<String>();
 
  ArrayList<String> juusyo = new ArrayList<String>();
 
  Integer info (Integer id,String btd){
      return id;
      
  }
  String info (String namae,String juusyo,PrintWriter pw){
      return namae;
  }
 String info (String juusyo){
     return juusyo;
 }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
 id.add(123);
 namae.add("れお");
btd.add("1996.7/29");
juusyo.add("Yokosuka");

 id.add(456);
  namae.add("レオ");
 btd.add("1996年07月29日"); 
 juusyo.add("yokouka");
 
 id.add(789);
 namae.add("怜於");
 btd.add("平成8年7月29日");
 juusyo.add("神奈川県横須賀市");
 
 
 
 
 
 
 
 int index = id.indexOf(123);
  Integer limit =2;

    
    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet suteruyatu</title>");            
            out.println("</head>");
            out.println("<body>");
    
   for (int i = 0; i < limit; i++) {
       out.println(id.get(index));
      out.println(namae.get(index));
       out.println(btd.get(index));
       out.println(juusyo.get(index));
   }            out.println("</body>");
            out.println("</html>");
    }        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
