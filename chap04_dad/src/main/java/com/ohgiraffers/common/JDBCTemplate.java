package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class JDBCTemplate {

    // 싱글톤
    private static Connection con;
    public static Connection getConnection(){

        Properties prop = new Properties();
        try {
            if(con == null || con.isClosed()){
                try {
                    prop.load(new FileReader("src/main/resources/config/connection_info.properties"));
                    String driver = prop.getProperty("driver");
                    String url = prop.getProperty("url");
                    Class.forName(driver);

                    con = DriverManager.getConnection(url, prop);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnection2(){

        Connection con2 = null;
        Properties prop = new Properties();
            try {
                prop.load(new FileReader("src/main/resources/config/connection_info.properties"));
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                Class.forName(driver);

                con2 = DriverManager.getConnection(url, prop);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        return con2;
        }

        public static void close(Connection con){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void close(Statement stmt){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void close(ResultSet rset){
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }


