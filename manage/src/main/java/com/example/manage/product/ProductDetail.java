package com.example.manage.product;

import DAO.Dao;
import Model.product;
import Model.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "productDetail", value = "/productDetail")
public class ProductDetail extends HttpServlet {
    private Dao dao;
    private static final long serialVersionUID = 1L;

    public void init() {
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        user role = (user) session.getAttribute("role");

            String product_id = req.getParameter("id");

        try {

            product pro = dao.getProductById(Integer.parseInt(product_id));


            req.setAttribute("product", pro);

            req.getRequestDispatcher("ProductDetail.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
