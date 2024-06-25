package DAO;

import Model.Product_Category;
import Model.category;
import Model.product;
import Model.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Dao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/manager?allowPublicKeyRetrieval=true&&useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "long@1605";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /*------------------Login, Register, Forget-------------------------------------*/
    private static final String check_phone = "SELECT * FROM user WHERE sdt=?";
    private static final String Check_Login = "SELECT * FROM user WHERE username=? AND password = ?";
    private static final String Update_Password = "update user set password = ? where sdt = ?";

    /*------------------User-------------------------------------*/

    private static final String Check_user = "SELECT * FROM user WHERE username=?";

    private static final String InsertUser = "INSERT INTO user(username, password, sdt) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_User = "SELECT * FROM user";

    private static final String DELETE_User = "DELETE FROM user WHERE id = ?";

    private static final String SELECT_User_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String Edit_user = "UPDATE user SET username = ?, password = ?, sdt = ?, role = ? WHERE id = ?";
    private static final String  SELECT_USER_BY_USERNAME = "SELECT * FROM user WHERE username LIKE ?";


    /*------------------Category-------------------------------------*/
    private static final String SELECT_ALL_Category = "SELECT * FROM category;";
    private static final String SELECT_ALL_Name_Category = "SELECT category_name FROM category";

    /*------------------Product-------------------------------------*/

    private static final String SELECT_ALL_Product = "SELECT * FROM product";

    private static final String SELECT_ALL_Product_categoryName = "SELECT p.product_id, p.product_name, p.price, p.created_at, p.description, c.category_name " +
            "FROM product p JOIN category c ON p.category_id = c.category_id;";

    public boolean checkUsernameExists(String username) throws ClassNotFoundException {

        Class.forName(JDBC_DRIVER);
        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(Check_user)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
           e.printStackTrace();
            return false;
        }

    }
    public user getUser(String username, String password) throws ClassNotFoundException {

        Class.forName(JDBC_DRIVER);
        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(Check_Login)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user user = new user();
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*public boolean checkLogin(String username, String password) throws ClassNotFoundException {

        Class.forName(JDBC_DRIVER);
        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(Check_Login)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }*/
    public boolean checkLPhone(String phone) throws ClassNotFoundException {

        Class.forName(JDBC_DRIVER);
        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(check_phone)) {

            preparedStatement.setString(1, phone);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public int insertUser(user u) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
          int result = 0;
        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(InsertUser)) {

            preparedStatement.setString(1, u.getUserName());
            preparedStatement.setString(2, u.getPassword());
            preparedStatement.setString(3, u.getPhoneNumber());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public boolean UpdatePass(String pass, String Phone) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(Update_Password)) {

            preparedStatement.setString(1, pass);
            preparedStatement.setString(2, Phone);


            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }

    }
    public List<user> getAllUser() throws ClassNotFoundException {
        List<user> users = new ArrayList<>();

        Class.forName(JDBC_DRIVER);

        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_User)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.printf(preparedStatement.toString());
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String sdt = resultSet.getString("sdt");
                String role = resultSet.getString("role");

                user user = new user(id, username, pass, sdt, role);
                users.add(user);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return users;
    }

    public List<category> getAllCategory() throws ClassNotFoundException {
        List<category> categories = new ArrayList<>();

        Class.forName(JDBC_DRIVER);

        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Category)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.printf(preparedStatement.toString());
            while (resultSet.next()) {
                int category_idd = resultSet.getInt("category_id");

                String category_namee = resultSet.getString("category_name");
                String descriptionn = resultSet.getString("description");


                category category = new category(category_idd, category_namee, descriptionn);
                categories.add(category);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return categories;
    }

    public List<product> getAllProduct() throws ClassNotFoundException {
        List<product> products = new ArrayList<>();

        Class.forName(JDBC_DRIVER);

        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Product)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.printf(preparedStatement.toString());
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");

                String ProductName = resultSet.getString("product_name");
                int category_id = resultSet.getInt("category_id");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                Date created_at = resultSet.getDate("created_at");

                product product = new product(productId, ProductName, category_id, price, description, created_at );
                products.add(product);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return products;
    }

    public List<Product_Category> getAllProduct_Category() throws ClassNotFoundException {
        List<Product_Category> products = new ArrayList<>();

        Class.forName(JDBC_DRIVER);

        try (Connection connection = getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Product_categoryName)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.printf(preparedStatement.toString());
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String ProductName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                String created_at = resultSet.getString("created_at");
                String categoryName = resultSet.getString("category_name");
                String description = resultSet.getString("description");


                Product_Category product = new Product_Category(productId, ProductName, price, created_at, categoryName, description);
                products.add(product);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return products;
    }
    public user getUserById(int id) throws ClassNotFoundException {
        user user = null;

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_User_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String sdt = resultSet.getString("sdt");
                String role = resultSet.getString("role");


                user = new user(id, username, password, sdt, role);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return user;
    }

    public  int editUser(user user) throws ClassNotFoundException, SQLException {
        int result = 0;

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(Edit_user)) {


            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getRole());

            preparedStatement.setInt(5, user.getId());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public void deleteUser(int id) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_User)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public List<user> getUserByUsername(String username) throws ClassNotFoundException {
        List<user> users = new ArrayList<>();

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, "%" + username + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String usernames = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String sdt = resultSet.getString("sdt");
                String role = resultSet.getString("role");


                user u = new user(id, usernames, pass, sdt, role);
                users.add(u);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return users;
    }

    public List<category> getAllNameCategory() throws ClassNotFoundException {
        List<category> Category_name = new ArrayList<>();

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Name_Category)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category category = new category();
                category.setCategory_name(resultSet.getString("category_name"));
                Category_name.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Category_name;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
