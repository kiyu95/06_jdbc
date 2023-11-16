package com.ohgiraffers.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application01 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties props = new Properties();

        System.out.println("변경을 원하는 메뉴명을 입력 해 주세요");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();

        System.out.println("변경할 메뉴명을 입력 해 주세요");
        Scanner scanner2 = new Scanner(System.in);
        String newName = scanner2.nextLine();

        int result = 0;

        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu_query.xml"));

            pstmt = con.prepareStatement(props.getProperty("updateMenu"));
            pstmt.setString(1, newName);
            pstmt.setString(2, name);

            result = pstmt.executeUpdate();
            System.out.println("결과 : " + result);
            if (result == 1) {
                System.out.println("변경이 완료되었습니다.");
            } else {
                System.out.println("다시 변경해 주세요");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(con);
            close(pstmt);
        }
    }
}
