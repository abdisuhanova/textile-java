package org.example;
import java.io.IOException;
import java.sql.*;

public class ConnectionDB {
    private static Connection connection;

    public static void forDelivery() throws IOException, SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "SELECT name FROM products WHERE provision_quantity = 1";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getString("name"));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    /*public static void listForSale() {
        String sql = "SELECT name FROM products WHERE provision_quantity = 0;";
    }
    public static void searchName(String name) {
        try {
            PreparedStatement sql = connection.prepareStatement("SELECT name FROM products WHERE name LIKE ? and provision_quantity = 0;");
            sql.setObject(1, name);
        } catch ( SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    public static void searchDate(String date) {
        try {
            PreparedStatement sql = connection.prepareStatement("SELECT name FROM products WHERE date LIKE ? and provision_quantity = 0;");
            sql.setObject(1, date);
        } catch ( SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    public static void sold() {
        String sql = "SELECT name FROM products where provision_quantity = 1";
    }
    public static void sell(String name) {
        try {
            PreparedStatement sql = connection.prepareStatement("update products set provision_quantity = provision_quantity + 1 where name like ?");
            sql.setObject(1, name);
        } catch ( SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    public static void cancel(String name) {
        try {
            PreparedStatement sql = connection.prepareStatement("update products set provision_quantity = provision_quantity - 1 where name like ?");
            sql.setObject(1, name);
        } catch ( SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public static void forDelivery() {
        try {
            String sql = "SELECT name FROM products WHERE provision_quantity = 1;";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch ( SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    public static void delivered() {
        String sql = "SELECT name FROM products WHERE delivered = 1";
            */
    }
}
