package Model;

import java.util.Date;

public class product {

    private int product_id;
    private String product_name;
    private int category_id;
    private double price;
    private String description;
    private Date created_at;

    public product() {
    }

    public product(int product_id, String product_name, int category_id, double price, String description, Date created_at) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category_id = category_id;
        this.price = price;
        this.description = description;
        this.created_at = created_at;
    }

    public product(int product_id, String product_name, int category_id, double price, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category_id = category_id;
        this.price = price;
        this.description = description;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
