package com.example.manage;

import DAO.Dao;
import Model.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "edit", value = "/edit")
public class edit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Dao dao;

    public void init() {
        dao = new Dao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            user existingUser = dao.getUserById(Integer.parseInt(id));
            if (existingUser != null) {
                req.setAttribute("user", existingUser);
                RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
                dispatcher.forward(req, resp);
            } else {
                // Xử lý trường hợp không tìm thấy Employee với id tương ứng
                resp.sendRedirect("list_user");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sdt = req.getParameter("phoneNumber");
        String role = req.getParameter("role");



        // Tạo đối tượng Employee với thông tin đã cập nhật
        user user = new user(id, username, password, sdt, role);

        try {
            // Cập nhật thông tin Employee
            dao.editUser(user);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Chuyển hướng về trang danh sách nhân viên
        resp.sendRedirect("list_user");
    }

    }

