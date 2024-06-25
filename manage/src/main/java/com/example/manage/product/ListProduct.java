package com.example.manage.product;

import DAO.Dao;
import Model.category;
import Model.product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListProduct", value = "/ListProduct")
public class ListProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Dao dao;

    public void init() {
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<product> products = dao.getAllProduct();
            req.setAttribute("products", products);
            List<category> categories = dao.getAllCategory();
            req.setAttribute("categoryy", categories);
            req.getRequestDispatcher("HomeShop.jsp").forward(req, resp);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
