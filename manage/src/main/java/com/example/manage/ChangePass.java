package com.example.manage;

import DAO.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "changePass", value = "/changePass")

public class ChangePass extends HttpServlet {
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
        String phone = req.getParameter("phone");
        String pass = req.getParameter("password");
        String re_pass = req.getParameter("re_password");

        if (!pass.equals(re_pass)) {

            req.setAttribute("message", "Passwords do not match!");
            req.setAttribute("pass", pass);
            req.setAttribute("re_pass", re_pass);
            req.setAttribute("phone", phone);
            req.getRequestDispatcher("/changePass.jsp").forward(req, resp);
            return;
        }
        try {
            boolean checkPhone = dao.checkLPhone(phone);
            if(!checkPhone) {
                req.setAttribute("messagePhone", "The phone number is not available!");
                req.setAttribute("phone", phone);
                req.getRequestDispatcher("/changePass.jsp").forward(req, resp);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            boolean checkPhone = dao.checkLPhone(phone);
           boolean result = dao.UpdatePass(pass, phone);
            if (result ) {
                req.setAttribute("ss", "Password updated successfully!");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
