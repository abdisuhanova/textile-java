package org.example;

import java.io.IOException;
import java.sql.*;
public class C {
    private static Connection connection;


    //saleman
    public static void listForSale() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT name FROM products WHERE provision_quantity = 0";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String str = result.getString("name");
                System.out.println(str);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchName(String name) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement sql = connection.prepareStatement("SELECT name FROM products WHERE name LIKE ? and provision_quantity = 0");
            sql.setObject(1, name);
            String s = sql.toString();
            ResultSet result = statement.executeQuery(s);
            while (result.next()) {
                String str = result.getString("name");
                System.out.println(str);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchDate(String date) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement sql = connection.prepareStatement("SELECT name FROM products WHERE date LIKE ? and provision_quantity = 0");
            sql.setObject(1, date);
            String s = sql.toString();
            ResultSet result = statement.executeQuery(s);
            while (result.next()) {
                String str = result.getString("name");
                System.out.println(str);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void soldOut() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT name FROM products where sold = 1";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String str = result.getString("name");
                System.out.println(str);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sell(String name) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement sql = connection.prepareStatement("update products set sold = sold + 1 where name like ?");
            sql.setObject(1, name);
            String s = sql.toString();
            statement.executeUpdate(s);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void order(String name) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement sql = connection.prepareStatement("update products set provision_quantity = provision_quantity + 1 where name like ?");
            sql.setObject(1, name);
            String s = sql.toString();
            statement.executeUpdate(s);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void cancel(String name) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement sql = connection.prepareStatement("update products set provision_quantity = provision_quantity - 1 where name like ?");
            sql.setObject(1, name);
            String s = sql.toString();
            statement.executeUpdate(s);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //deliveryman
    public static void forDelivery() throws IOException, SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/java-project1";
        String username = "postgres";
        String password = "49577982";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT name FROM products WHERE provision_quantity = 1";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String str = result.getString("name");
                System.out.println(str);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}

