/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author leo_e
 */
public class BJ1 extends HttpServlet {
//abstractは必ず継承する。
//抽象クラス

    abstract class Human {

        //openはカードの合計値の計算して返す
        abstract public int open();

        //setCardは、手札としてセットするときに使う、ユーザーディーラーそれぞれに用意する
        //setCardというArrayListを引数とした、abstractな公開メソッドを用意
        abstract public void setCard(ArrayList<Integer> sC);
        //checkSumというabstractな公開メソッドを用意してください。
        //checkSum 自分の今の合計値と２１を比べ引くべきか十分かチェックする

        abstract public boolean checkSum();
        //myCardsというArrayListの変数を用意してください。
        //myCards  自分の手札を管理する
        ArrayList<Integer> myCards = new ArrayList<>();

    }

    class Dealer extends Human {

        ArrayList<Integer> Cards = new ArrayList<>();

        int ftotal = 0;

        //クラス初期処理 
        public Dealer() {
            //トランプ52枚分をcardsに追加 
            //cards合計数52にするため、4回繰り返す。 
            for (int h = 0; h < 4; h++) {
                //1~Kを加える(J,Q,K == 10) 
                for (int i = 1; i <= 13; i++) {
                    if (i <= 10) {
                        Cards.add(i);
                    } else {
                        Cards.add(10);
                    }
                }
            }
        }
        //   private Integer yamahuda = (null);

        public ArrayList<Integer> deal() {

            ArrayList<Integer> dl = new ArrayList<>();

            for (int i = 0; i < 2; i++) {

                Random rand = new Random();
                Integer renum = rand.nextInt(Cards.size());
                dl.add(Cards.get(renum));
                Cards.remove(renum);
            }
            return dl;
        }

        public ArrayList<Integer> hit() {

            ArrayList<Integer> ht = new ArrayList<>();

            for (int i = 0; i < 1; i++) {

                Random rand = new Random();
                Integer renum = rand.nextInt(Cards.size());
                ht.add(Cards.get(renum));
                Cards.remove(renum);
            }
            return ht;
        }
//setCardの実装

        @Override
        public void setCard(ArrayList<Integer> sC) {
            for (int i = 0; i < sC.size(); i++) {

                myCards.add(sC.get(i));
            }
        }
//checkSumの実装

        @Override
        public boolean checkSum() {

            if (ftotal < 16) {
                if (ftotal == 11 && myCards.contains(1)) {

                    return false;
                }
                return true;
            } else {
                return false;
            }
        }
//openの実装

        @Override
        public int open() {
            int total = 0;
            for (int value : myCards) {
                if (total < 21) {

                    total += value;
                } else {
                    break;
                }
            }

            ftotal = total;
            return ftotal;
        }
    }

    class User extends Human {

        int ftotal = 0;
//setCardの実装
//setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。

        @Override
        public void setCard(ArrayList<Integer> sC) {
            for (int i = 0; i < sC.size(); i++) {

                myCards.add(sC.get(i));
            }
        }

        //checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください
//checkSumの実装
        @Override
        public boolean checkSum() {

            if (ftotal < 16) {
                if (ftotal == 11 && myCards.contains(1)) {

                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        //openは、myCardsのカードの合計値を返却するように実装してください。
//openの実装
        @Override
        public int open() {
            int total = 0;
            for (int value : myCards) {
                if (total < 21) {

                    total += value;
                } else {
                    break;
                }
            }

            ftotal = total;
            return ftotal;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            Dealer dealer = new Dealer();

            User user1 = new User();

            //deal分の2枚をsetCardに渡す 
            dealer.setCard(dealer.deal());
            out.println(
                    "ディーラーオープンカード" + dealer.myCards.get(0) + "<br>");

            while (dealer.open()
                    < 17) {

                dealer.setCard(dealer.hit());
            }

            //user1のカード 
            user1.setCard(dealer.deal());
            out.println(
                    "あなたの手札は" + user1.myCards + "なので合計" + user1.open() + "<br>");

            while (user1.checkSum()
                    == true) {

                user1.setCard(dealer.hit());
                out.println("プレイヤーヒット!<br>");
                out.println("カードの合計値は " + user1.myCards + "なので合計" + user1.open() + "<br>");
            }

            //勝敗表示 
            //bust処理 
            if (user1.open()
                    > 21) {

                out.println("あなたの負けです....");

            } else if (dealer.open()
                    <= 21) {

//dealer bj 
                if (dealer.open() == user1.open()) {
                    out.println("ディーラーの合計、" + dealer.open() + "あなたの合計" + user1.open() + ".<br>");
                    out.println("なので引き分け");
                } else if (dealer.open() == 21) {
                    if (user1.open() == 11 && user1.myCards.contains(1)) {
                        out.println("ディーラーはナチュラルブラック！,ユーザもナチュラルブラック！.<br>");
                        out.println("引き分け");
                    } else {
                        out.println("ディーラーは21" + dealer.open() + "ナチュラルブラックです!ディーラーの勝ち！");
                    }
                } else if (user1.open() == 11 && user1.myCards.contains(1)) {
                    out.println("あなたはの手札は21、ナチュラルブラックジャックです！あなたの勝ち！");
                } else if (dealer.open() > user1.open()) {
                    out.println("ディーラーの手札は" + dealer.open() + ",あなたの手札は" + user1.open() + ".<br>");
                    out.println("ディーラーの勝ちです!<br>");
                } else {
                    out.println("ディーラーの手札は" + dealer.open() + ", あなたの手札は" + user1.open() + ".<br>");
                    out.println("あなたの勝ちです！");
                }
            } else {

                out.println("ディーラーの手札は" + dealer.open() + ",あなたの手札は" + user1.open() + ".<br>");
                out.println("あなたの勝ちです！");
            }
//BlackJackの舞台は、Servletクラスでも、Javaクラスのpublic static void mainでも構いません。
//カードのやり取りは自動で構いません、カードの変化と最終結果を表示してください。

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ブラックジャック</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ブラックジャック<h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

//dealという公開メソッドを用意し、cardsからランダムで2枚のカードをArrayListにして返却してください。
//hitという公開メソッドを用意し、cardsからランダムで1枚のカードをArrayListにして返却してください。
//setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
//checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください
//openは、myCardsのカードの合計値を返却するように実装してください。
//setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
//checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください
//openは、myCardsのカードの合計値を返却するように実装してください。
//BlackJackの舞台は、Servletクラスでも、Javaクラスのpublic static void mainでも構いません。
//カードのやり取りは自動で構いません、カードの変化と最終結果を表示してください。
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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