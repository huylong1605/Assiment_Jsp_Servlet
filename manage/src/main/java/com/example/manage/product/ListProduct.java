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
        /*String category_name = req.getParameter("category_name");*/
//https://chatgpt.com/share/8af5abd6-5bff-45b0-9d65-a31ccdf88868
        String index =  req.getParameter("index");
        List<product> products;

        if(index == null) {
            index = "1";
        }
        try{
            /*if(category_name != null) {*/
                /*products = dao.GetFilterProduct(Integer.parseInt(index), category_name);*/


           /* }else {*/
                products = dao.GetProductByIndex(Integer.parseInt(index));
            /*}*/


               int count = /*dao.getTotalProduct(category_name);*/ dao.getTotalProduct();

            int endPage = count/4;
            if(count % 4 != 0){
                endPage++;
            }
            /*List<product> products = dao.getAllProduct();*/
            req.setAttribute("endP", endPage);
            req.setAttribute("products", products);
            req.setAttribute("tag", index);
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
