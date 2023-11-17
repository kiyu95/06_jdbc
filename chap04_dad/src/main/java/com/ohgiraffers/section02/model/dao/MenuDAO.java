package com.ohgiraffers.section02.model.dao;

import com.ohgiraffers.section02.model.dto.MenuDTO;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuDAO {
    // DAO(data access object)

    private Properties prop = new Properties();

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int selectLastMenuCode(Connection con){
        Statement statement = null;
        ResultSet rset = null;
        int maxCode = 0;

        String query = prop.getProperty("selectLastMenuCode");
        try {
            statement = con.createStatement();
            rset = statement.executeQuery(query);
            if (rset.next()){
                maxCode = rset.getInt("MAX(A.MENU_CODE)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(statement);
            close(rset);
        }
        return maxCode;
    }

    public List<Map<Integer, String>> selectAllcategory(Connection con){
        Statement statement = null;
        ResultSet rset = null;
        List<Map<Integer, String>> categroyList = new ArrayList<>();

        String query = prop.getProperty("selectAllcategoryList");
        try {
            statement = con.createStatement();
            rset = statement.executeQuery(query);
            while (rset.next()){
                Map<Integer, String> category = new HashMap<>();
                category.put(rset.getInt("CATEGORY_CODE"), rset.getString("CATEGORY_NAME"));
                categroyList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(statement);
            close(rset);
        }
        return categroyList;
    }

    public int insertMenu(Connection con, MenuDTO menuDTO){
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMenu");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuDTO.getMenuName());
            pstmt.setInt(2, menuDTO.getPrice());
            pstmt.setString(3, menuDTO.getCategoryCode());
            pstmt.setString(4, menuDTO.getStatus());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }
        return result;
    }


}
