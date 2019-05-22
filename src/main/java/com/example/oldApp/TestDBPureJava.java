//package com.example;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TestDBPureJava
//{
//    private Connection connection = null;
//
//    public static void main(String[] args)
//    {
//
//        TestDBPureJava test = new TestDBPureJava();
//        if (!test.loadDriver()) return;
//        if (!test.getConnection()) return;
//
//        test.dropDB();
//        test.createTable();
//        test.fillTable();
//        test.printTable();
//        test.closeConnection();
//    }
//
//    private boolean loadDriver() {
//        try {
//            Class.forName("org.hsqldb.jdbcDriver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("DriverManager not found");
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    private boolean getConnection() {
//
//        try {
//            String path = "mypath/";
//            String dbname = "mydb";
//            String connectionString = "jdbc:hsqldb:file:"+path+dbname;
//            String login = "joe";
//            String password = "password";
//            connection = DriverManager.getConnection(connectionString, login, password);
//
//        } catch (SQLException e) {
//            System.out.println("Connection not created.");
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    private void createTable() {
//        try {
//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE testTable (id IDENTITY , value VARCHAR(255), price DOUBLE)";
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//
//        }
//    }
//
//    private void fillTable() {
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            String sql = "INSERT INTO testTable (value) VALUES('Order one')";
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Order two') " ;
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Order')";
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Order four')";
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Order five')";
//            statement.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void printTable() {
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            String sql = "SELECT id, value FROM testTable";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + " "
//                    + resultSet.getString(2));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void closeConnection() {
//
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            String sql = "SHUTDOWN";
//            statement.execute(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private void dropDB() {
//        try {
//            Statement statement = connection.createStatement();
//            String sql = "DROP SCHEMA PUBLIC CASCADE";
//            statement.execute(sql);
//        } catch (SQLException e) {
//
//        }
//    }
//}
