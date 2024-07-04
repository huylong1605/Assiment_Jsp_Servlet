package com.example.manage;

import DAO.Dao;
import Model.user;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    private Dao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new Dao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            user user = dao.getUser(username, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("role", user); // Lưu user vào session
                //session.setMaxInactiveInterval(100);

                if (user.getRole().equals("admin")) {
                   /* req.getRequestDispatcher("/admin.jsp").forward(req, resp);*/
                    resp.sendRedirect("admin.jsp");
                } else if (user.getRole().equals("user")) {
                    resp.sendRedirect("ListProduct");

                }

            } else {
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                req.setAttribute("message1", "Username or password incorrect");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        /*if ("admin".equals(username) && "123".equals(password)) {
            resp.sendRedirect("list_user");
            return;
        }

        try {
                boolean checkLogin = dao.checkLogin(username, password);
                if (checkLogin) {

                    req.getRequestDispatcher("/lendingPage.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message1", "Username or password incorect");
                    req.setAttribute("username", username);
                    req.setAttribute("password", password);
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }*/

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

