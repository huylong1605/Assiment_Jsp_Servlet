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

@WebServlet(name = "list_user", value = "/list_user")
public class ListUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Dao dao;

    public void init() {
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index =  req.getParameter("index");

        if(index == null) {
            index = "1";
        }

        try{

                List<user> user = dao.GetByIndex(Integer.parseInt(index));

            int count = dao.getTotalUser();
            int endPage = count/3;
            if(count % 3 != 0){
                endPage++;
            }

            req.setAttribute("endP", endPage);
            req.setAttribute("users", user);
            req.setAttribute("tag", index);
            req.getRequestDispatcher("adminUser.jsp").forward(req, resp);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
