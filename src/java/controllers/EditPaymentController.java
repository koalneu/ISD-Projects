/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import models.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
/**
 *
 * @author tylershienlim
 */
public class EditPaymentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        //Retrieve updated payment details
        //int amount = Integer.parseInt(request.getParameter("paymentAmount"));
        int cardNo = Integer.parseInt(request.getParameter("cardno"));
        int cvv = Integer.parseInt(request.getParameter("cardcvv"));
        String cardName = request.getParameter("cardname");
        String cardDate = request.getParameter("cardexpiry");        
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try {
            //update payment details to customer's payment details using email value column
        } catch (SQLException ex) {
             Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
         }  
    }
}
