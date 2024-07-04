package com.example.manage.product;

import DAO.Dao;
import Model.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addToCart", value = "/addToCart")
public class AddToCart extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Dao dao;

    public void init() {
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product_id = req.getParameter("Pid");

        HttpSession session = req.getSession();
        user currentUser = (user) session.getAttribute("role");

        if (currentUser != null) {
            try {
                dao.AddToCart(currentUser.getId(), Integer.parseInt(product_id));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("CartList");
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
