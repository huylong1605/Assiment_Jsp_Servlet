package com.example.manage.product;

import DAO.Dao;
import Model.Product_Category;
import Model.category;
import Model.product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListProductCategory", value = "/ListProductCategory")
public class ListProductCategory extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao dao = new Dao();
        List<Product_Category> products = null;
        try {
            products = dao.getAllProduct_Category();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("products", products);
        req.getRequestDispatcher("adminProduct.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
