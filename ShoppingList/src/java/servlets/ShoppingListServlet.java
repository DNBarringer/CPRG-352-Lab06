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
        String username = loginInfo[0];
        req.setAttribute("username", username);
        String myAction = req.getParameter("action");
        
        
        if (myAction != null) {
            switch (myAction) {
                case "register":
                    if (username != null && !username.isEmpty()) {
                        session.setAttribute("s_username", username);
                        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(req,resp);
                    } else {
                        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
                    } 
                    break;
                case "add": break;
                case "delete": break;
            }
        }
        
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String myAction = req.getParameter("action");
        String username = (String)session.getAttribute("s_username");
        
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
