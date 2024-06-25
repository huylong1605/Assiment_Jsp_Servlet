package Model;

import java.sql.Date;

public class Product_Category {
     private int ProductId;
     private String product_name;
    private double price;
    private String created_at;
    private String category_name;
    private String description;

    public Product_Category() {
    }

    public Product_Category(int productId, String product_name, double price, String created_at, String category_name, String description) {
        ProductId = productId;
        this.product_name = product_name;
        this.price = price;
        this.created_at = created_at;
        this.category_name = category_name;
        this.description = description;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
