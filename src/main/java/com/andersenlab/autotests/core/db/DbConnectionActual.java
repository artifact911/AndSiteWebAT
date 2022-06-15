package com.andersenlab.autotests.core.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnectionActual {
    /**
     * флоу по работе с классом:
     * 1. первым используем метод openConnection для подключения к БД (в каждом степе)
     * 2. далее используем необходимые методы (при необходимости дописываем новые методы в этом классе)
     * 2.1. на данный момент (декабрь 21) реализован селект (принимает в качестве параметра метод createSelectQuery)
     * 2.2. для работы с инсертом, делитом, адпейтом используем метод createIUDQuery (I-insert, U-update, D-delete)
     * 2.3. createIUD рабочий, но на декабрь 21 в нем нет необходимости
     * 3. в конце обязательно используем метод closeConnection для закрытия подключения (в каждом степе)
     * 3.1. для закрытия селект метода closeConnectionSelect, для запросов IUD - closeConnectionIUD
     */

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void openConnection(String URL, String USER, String PASSWORD) throws SQLException {
        con = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnectionSelect() throws SQLException {
        con.close();
        stmt.close();
        rs.close();
    }

    public static void closeConnectionIUD () throws SQLException{
        con.close();
        stmt.close();
    }

    public static String createSelectQuery(String query) throws SQLException {
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        return query;
    }

    public static void createIUDQuery(String query) throws SQLException {
        stmt = con.createStatement();
        stmt.executeUpdate(query);
    }

    public static List<String> selectRecords(String query) {
        List<String> list = new ArrayList<>();
        try {
            while (rs.next()) {
                String columnName = rs.getString(1);
                String columnName2 = rs.getString(2);
                String columnName3 = rs.getString(3);
                String columnName4 = rs.getString(4);
                String columnName5 = rs.getString(5);
                String nda = columnName5.trim() + "\n";
                list.add(columnName);
                list.add(columnName2);
                list.add(columnName3);
                list.add(columnName4);
                list.add(nda);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static int counterOfRecords(String query) throws SQLException {
        int counter = 0;
        while (rs.next()) {
            counter = rs.getInt(1);
        }
        return counter;
    }
}


