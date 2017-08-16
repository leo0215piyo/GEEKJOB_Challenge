/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

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
public class Class1 extends HttpServlet {

//    private void name(PrintWriter out) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void juusyo(PrintWriter out) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    class Human {
        //パブリックな２つの変数
        public String name = "";
        public String juusyo = "";
        //２つの変数に値を設定するパブリックなメソッド
        public void setHuman(String n, String j) {

            this.name = n;
            this.juusyo = j;
        }
        //２つの変数の中身をprintするパブリックなメソッド
        public void data(PrintWriter pw){
            
            pw.print(name);
            pw.print(juusyo);
        }
        
        
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //インスタンス作成
            Human hito = new Human();
            
            //２つの変数に値を設定するパブリックなメソッドを使用して値を設定
            hito.setHuman("大塚怜於","横須賀市");
            
            //２つの変数の中身をprintするパブリックなメソッドを使用して変数の中身を表示
            hito.data(out);
            
            
            
            
            //hito.name = ("大塚怜於");
            //hito.juusyo = ("横須賀");

            //name(out);
            //juusyo(out);

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
