package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.Employee2DTO;
import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application04 {
    public static void main(String[] args) {

        // 객체(objects)는 사전적인 정의로 실제 존재하는 것을 말한다.

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        // 200
        // 선동일
        // 621235-1985634
        // sun_di@greedy.com
        // 01099546325
        // D9
        // J1
        // S1
        // 8000000
        // 0.3
        // 1990-02-06
        // N
        Employee2DTO nonBilder = new Employee2DTO();
        nonBilder.setEmpId("200");
        nonBilder.setEmpName("선동일");
        System.out.println(nonBilder);

        EmployeeDTO builderEmp = new EmployeeDTO().setempNo("621235-1985634").setbonus(0.3).setEmpId("200").setjobCode("j1");
        System.out.println(builderEmp);

        Scanner scanner = new Scanner(System.in);
        System.out.println("조회할 사번을 입력해주세요 : ");
        String empId = scanner.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId+"'";
        EmployeeDTO emp = null;
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                emp = new EmployeeDTO()
                        .setempNo(rset.getString("EMP_NO"))
                        .setEmpId(rset.getString("EMP_ID"))
                        .setempName(rset.getString("EMP_NAME"))
                        .setemail(rset.getString("EMAIL"))
                        .setphone(rset.getString("PHONE"));
            }
            System.out.println(emp);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(rset);
            close(stmt);
        }
    }
}
