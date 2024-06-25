package com.example.manage;

import DAO.Dao;
import Model.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchUser", value = "/SearchUser")
public class searchUser extends HttpServlet {
    private Dao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchUser = req.getParameter("searchUser");


        try {
            List<user> users = dao.getUserByUsername(searchUser);
            req.setAttribute("users", users);
            req.getRequestDispatcher("adminUser.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
