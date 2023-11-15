package com.ohgiraffers.understand;

import static com.ohgiraffers.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application02 {
    public static void main(String[] args) {

        // 선동일 사원의 사번, 이름, 연락처, 직급이 무엇인지 출력하세요
        // 1. connection DB
        // 2. 쿼리를 만들어야 한다. Statement
        // 3. 쿼리를 보낸다.
        // 4. 결과를 받는다. ResultSet

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT " +
                    "EMP_ID ," +
                    "EMP_NAME ," +
                    "PHONE ," +
                    "JOB_NAME" +
                    "  FROM EMPLOYEE" +
                    "  JOIN JOB ON EMPLOYEE.JOB_CODE = JOB.JOB_CODE" +
                    " WHERE EMP_NAME LIKE '선동일';");

            while (rset.next()){
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME") + " " + rset.getString("PHONE") + " " + rset.getString("JOB_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(con);
            close(rset);
            close(stmt);
        }
    }
}
