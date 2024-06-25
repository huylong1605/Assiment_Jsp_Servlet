package com.example.manage;

import DAO.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgetPassword", value = "/ForgetPassword")

public class ForgetPass extends HttpServlet {
    private Dao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phone = req.getParameter("phone");
        try {
            boolean checkPhone = dao.checkLPhone(phone);
            if(!checkPhone) {
                req.setAttribute("message", "The phone number is not available!");
                req.getRequestDispatcher("/checkPhone.jsp").forward(req, resp);

            }else{
                req.setAttribute("phone", phone);
                req.getRequestDispatcher("/changePass.jsp").forward(req, resp);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
