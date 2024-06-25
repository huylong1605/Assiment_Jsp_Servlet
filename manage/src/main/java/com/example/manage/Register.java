package com.example.manage;

import DAO.Dao;
import Model.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {
    private static final String PHONE_NUMBER_PATTERN = "^0[35789]\\d{8}$";
    private static final Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
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

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String re_password = req.getParameter("re_password");
        String phone = req.getParameter("phone");

        if (!password.equals(re_password)) {

            req.setAttribute("message1", "Passwords do not match!");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        if (!VietNamPhone(phone)){
            req.setAttribute("message4", "phone do not match!");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        try {
            boolean checkPhone = dao.checkLPhone(phone);
            if(checkPhone ) {
                req.setAttribute("message3", "phone already exists!");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            boolean checkUserName = dao.checkUsernameExists(userName);
                if(!checkUserName){
                     user user = new user();
                        user.setUserName(userName);
                        user.setPassword(password);
                        user.setPhoneNumber(phone);

                   dao.insertUser(user);
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }else {
                    req.setAttribute("message2", "Username already exists!");
                    req.getRequestDispatcher("/register.jsp").forward(req, resp);
                }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private  boolean VietNamPhone(String phone) {
        // Regex cho số điện thoại Việt Nam
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}
