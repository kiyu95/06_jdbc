package com.ohgiraffers.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application01 {

    public static void main(String[] args) {

        // 급여를 가장 많이 받는 사원의 사번, 이름, 연락처를 조회한다.
        // 1. connection DB
        // 2. 쿼리를 만들어야 한다. Statement
        // 3. 쿼리를 보낸다.
        // 4. 결과를 받는다. ResultSet

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME, PHONE FROM employee ORDER BY SALARY DESC LIMIT 1");

            while (rset.next()){
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME") + " " + rset.getString("PHONE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(con);
            close(stmt);
            close(rset);
        }
    }
}
