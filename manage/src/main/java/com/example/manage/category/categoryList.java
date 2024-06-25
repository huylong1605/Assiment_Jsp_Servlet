package com.example.manage.category;

import DAO.Dao;
import Model.category;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "categoryList", value = "/categoryList")
public class categoryList extends HttpServlet {
    private Dao dao;

    public void init() {
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<category> categories = dao.getAllCategory();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("listCategory.jsp").forward(req, resp);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
