package Model;

import DAO.Dao;

import java.util.Date;

public class CartItem {
    private int cart_id;
    private int quantity;
    private Date add_date;


    private String product_name;
    private double price;
    private String description;
    private String category_name;



    public CartItem() {
    }

    public CartItem(int cart_id, int quantity, Date add_date, String product_name, double price, String description, String category_name) {
        this.cart_id = cart_id;
        this.quantity = quantity;
        this.add_date = add_date;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.category_name = category_name;
    }

    /*public CartItem(int cart_id, int quantity, Date add_date, String product_name, String description, String category_name) {
        this.cart_id = cart_id;
        this.quantity = quantity;
        this.add_date = add_date;
        this.product_name = product_name;
        this.description = description;
        this.category_name = category_name;
    }*/

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
