package com.example.manage.product;

import DAO.Dao;
import Model.category;
import Model.product;
import Model.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String category_name = req.getParameter("category_name");
        HttpSession session = req.getSession();
        user currentUser = (user) session.getAttribute("role");
//https://chatgpt.com/share/8af5abd6-5bff-45b0-9d65-a31ccdf88868
        String index =  req.getParameter("index");
        List<product> products = null;

        if(index == null) {
            index = "1";
        }
        try{
            /*int pageIndex = Integer.parseInt(index);*/
            if(category_name == null || category_name.isEmpty()) {

                products = dao.GetProductByIndex(Integer.parseInt(index));

            }else {

                products = dao.GetFilterProduct(Integer.parseInt(index), category_name);
            }
            int count;
            if(category_name == null || category_name.isEmpty()) {
                 count = dao.getTotalProduct();

            }else{
                count = dao.getTotalProduct(category_name);
            }
            int endPage = count/4;
            if(count % 4 != 0){
                endPage++;
            }
            int countCart = dao.getTotalCart(currentUser.getId());

            req.setAttribute("endP", endPage);
            req.setAttribute("countCart", countCart);
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
