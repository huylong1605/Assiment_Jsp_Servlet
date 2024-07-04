package Model;

import java.util.Date;

public class addToCart {
      private int cartId;
      private int userId;
      private int productId;
      private  int quanlity;
      private Date add_Date;

      public addToCart() {
      }

      public addToCart(int cartId, int uesrId, int productId, int quanlity, Date add_Date) {
            this.cartId = cartId;
            this.userId = uesrId;
            this.productId = productId;
            this.quanlity = quanlity;
            this.add_Date = add_Date;
      }

      public int getCartId() {
            return cartId;
      }

      public void setCartId(int cartId) {
            this.cartId = cartId;
      }

      public int getuserIdId() {
            return userId;
      }

      public void setUesrId(int uesrId) {
            this.userId = uesrId;
      }

      public int getProductId() {
            return productId;
      }

      public void setProductId(int productId) {
            this.productId = productId;
      }

      public int getQuanlity() {
            return quanlity;
      }

      public void setQuanlity(int quanlity) {
            this.quanlity = quanlity;
      }

      public Date getAdd_Date() {
            return add_Date;
      }

      public void setAdd_Date(Date add_Date) {
            this.add_Date = add_Date;
      }
}
