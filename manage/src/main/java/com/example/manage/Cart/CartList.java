package com.example.manage.Cart;

import DAO.Dao;
import Model.CartItem;
import Model.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartList", value = "/CartList")
public class CartList extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Dao dao;

    public void init() {
        dao = new Dao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        user currentUser = (user) session.getAttribute("role");
        try {
            List<CartItem> CI = dao.getAllCart(currentUser.getId());
            req.setAttribute("CartList", CI);
            req.getRequestDispatcher("addToCart.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
