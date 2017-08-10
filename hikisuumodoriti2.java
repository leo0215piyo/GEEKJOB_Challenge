package modoriti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leo_e
 */
public class hikisuumodoriti2 extends HttpServlet {

   String[] myprofile(String name, PrintWriter pw){
     String[] data1 = {"123", "れお", "1996年07月29日", "神奈川県横須賀市"};
     String[] data2 = {"456","レオ","平成8年7月29日","Yokosuka"};
     String[] data3 = {"789","怜於","1996.7/29","Kanagawa"};
     if(name.equals(data1[0])){return data1;}
     else if(name.equals(data2[0])){return data2;}
     else{return data3;} 
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
            String[] data1 = myprofile("123",out);
            String[] data2 = myprofile("456",out);
            String[] data3 = myprofile("789",out);
            for (int i = 1; i < data1.length; i++) {  
                
                if(data1 == null){
                    continue;
                }
                    
                out.print(data1[i]);
                out.print(data2[i]);
                out.print(data3[i]);
                
            
        }
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