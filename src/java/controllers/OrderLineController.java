/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import models.dao.DBManager;

/**
 *
 * @author mjra9
 */
public class OrderLineController extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String productName = request.getParameter("productName");
        String operation = request.getParameter("operation");
        if(productName == null && operation == null){
           request.getRequestDispatcher("products.jsp").include(request, response);
        }
        else{
            Order order = (Order) session.getAttribute("order");
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
                Product productAdded = new Product();
                for(Product product : products){
                    if(product.getProductName().equals(productName)){
                        productAdded = product;
                    }
                }
            OrderLine productToUpdate = order.checkProduct(productAdded);
            if (operation.equals("-")){
                order.subtractQuantity(productToUpdate);
                //System.out.println("subtracting to order");
            }
            //else if(operation.equals("+")){
            else{
                order.addQuantity(productToUpdate);
                //System.out.println("adding to order");
            }
            request.getRequestDispatcher("cart.jsp").include(request, response);
        }    
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
        request.getRequestDispatcher("checkout.jsp").include(request, response);
    }

    

}
