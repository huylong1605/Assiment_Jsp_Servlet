package com.example.manage;

import DAO.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUser", value = "/deleteUser")
public class DeleteUser extends HttpServlet {

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
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            dao.deleteUser(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("list_user");
    }
}
