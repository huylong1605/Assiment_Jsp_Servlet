package com.example.manage.Cart;

import DAO.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteProductCart", value = "/deleteProductCart")
public class DeleteCart extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Dao dao;

    public void init() {
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartId = req.getParameter("cartId");
        String messString = "Delete successful";
        try {
            dao.deleteCart(Integer.parseInt(cartId));
            resp.sendRedirect("CartList?success=true");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
