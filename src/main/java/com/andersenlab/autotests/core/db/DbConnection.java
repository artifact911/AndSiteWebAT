package com.andersenlab.autotests.core.db;

import com.andersenlab.autotests.core.utils.PropertiesReader;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class DbConnection {
    private static String URL;
    private static String LOGIN;
    private static String PASSWORD;

    public DbConnection() {
        URL = PropertiesReader.get("application.db.url");
        LOGIN = PropertiesReader.get("application.db.login");
        PASSWORD = PropertiesReader.get("application.db.password");
    }

    @Step("DB update query")
    public boolean update(String query) {
        Connection connection = createConnection();
        try {
            connection.createStatement().executeQuery(query);
        } catch (SQLException e) {
            addToLog(query, "error");
            addToAllure(query, "error");
            return false;
        }
        closeConnection(connection);

        addToLog(query, "success");
        addToAllure(query, "success");

        return true;
    }

    @Step("DB select query")
    public String searchTillFound(String query, int timeoutS) {
        int delayBetweenRetriesMs = 500;
        int timeoutMs = timeoutS * 1000;
        long startTime = System.currentTimeMillis();
        String result = null;

        Connection connection = createConnection();

        while ((startTime + timeoutMs) > System.currentTimeMillis() && (result == null || result.equals("") || result.equals("null"))) {
            result = getResult(connection, query);
            if (result == null || result.equals("")) {
                sleep(delayBetweenRetriesMs);
            }
        }
        closeConnection(connection);

        addToLog(query, result);
        addToAllure(query, result);

        return result;
    }

    private Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            log.error("DB connection Failed! Check output console");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e){
            log.error("DB connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    private String getResult(Connection connection, String sql) {
        try {
            connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            ResultSetMetaData metaData = result.getMetaData();
            StringBuffer sb = new StringBuffer();

            while (result.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (sb.length() == 0) {
                        sb.append(result.getString(i));
                    } else {
                        sb.append(" ").append(result.getString(i));
                    }
                }
            }

            if (sb.toString().equals("null")) return null;
            return sb.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void addToLog(String query, String response) {
        log.info("==============================");
        log.info("Request to DB: " + query);
        log.info("Response from DB: " + response);
        log.info("==============================");
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Request details", type = "text/plain")
    private String addToAllure(String query, String response) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("============================================================").append(System.lineSeparator());
        buffer.append("Request to DB: ").append(query).append(System.lineSeparator());
        buffer.append("Response from DB: ").append(response).append(System.lineSeparator());
        buffer.append("============================================================").append(System.lineSeparator());
        return buffer.toString();
    }

    private void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
