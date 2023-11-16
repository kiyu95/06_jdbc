package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application01 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties props = new Properties();

        System.out.println("삭제할 메뉴이름을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int result = 0;

        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu_query.xml"));
            pstmt = con.prepareStatement(props.getProperty("deleteMenu"));
            pstmt.setString(1, name);

            result = pstmt.executeUpdate();
            System.out.println("결과 : " + result);
            if (result == 1){
                System.out.println("메뉴를 삭제하였습니다.");
            } else {
                System.out.println("다시 삭제해주세요");
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
