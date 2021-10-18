/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ShopList;
import services.ShopListService;

/**
 *
 * @author david
 */
public class ShoppingListServlet extends HttpServlet {

    private final int PAGE_SIZE = 10;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String[] loginInfo = req.getParameterValues("loginInfo[]");
        boolean validated = false;

        String myAction = req.getParameter("action");

        
        ShopListService shopListService = new ShopListService();
        ShopList myShoppingList;
        
        if (session.getAttribute("myShoppingList") == null) {
            myShoppingList = shopListService.getShoppingList();
        } else {
            myShoppingList = (ShopList) session.getAttribute("myShoppingList");
        }
     
        if (myAction != null) {
            switch (myAction) {
                case "register":
                    String username = loginInfo[0];
                    req.setAttribute("username", username);
                    if (username != null && !username.isEmpty()) {
                        session.setAttribute("s_username", username);
                        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(req,resp);
                    } else {
                        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
                    } 
                    break;
                case "add":
                    String itemToAdd = req.getParameter("itemToAdd");
                    myShoppingList.addItem(itemToAdd);
                    break;
                case "delete":
                    myShoppingList.deleteItem(req.getParameter("item"));
                    break;
            }
        }

        session.setAttribute("myShoppingList", myShoppingList);
        req.setAttribute("myShoppingList", myShoppingList.getShoppingListArray());
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(req,resp);
        
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String myAction = req.getParameter("action");
        String username = (String)session.getAttribute("s_username");
        
        
        ShopListService shopListService = new ShopListService();
        ShopList myShoppingList;
        if (session.getAttribute("myShoppingList") == null) {
            myShoppingList = shopListService.getShoppingList();
        } else {
            myShoppingList = (ShopList) session.getAttribute("myShoppingList");
        }
        req.setAttribute("myShoppingList", myShoppingList.getShoppingListArray());
        
        if ((myAction != null) && (myAction.equals("logout"))) {
            session.invalidate();
            req.setAttribute("message", "Successfully logged out!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
        }
        
        if (username != null && !username.isEmpty()) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(req,resp);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
        }
    }
    
}
