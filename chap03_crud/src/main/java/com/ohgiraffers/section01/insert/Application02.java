package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application02 {
    public static void main(String[] args) {

        // 사용자가 메뉴를 등록 할 수 있도록 만들어주세요.
        // 등록이 완료되면 메뉴등록 성공 실패하면 다시 등록을 요청해주세요.

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties props = new Properties();

        System.out.println("메뉴명을 입력 해 주세요");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();

        System.out.println("가격을 입력 해 주세요");
        Scanner scanner2 = new Scanner(System.in);
        int price = scanner2.nextInt();

        System.out.println("카테고리 코드를 입력 해 주세요");
        Scanner scanner3 = new Scanner(System.in);
        int category = scanner3.nextInt();

        System.out.println("판매상태를 입력 해 주세요");
        Scanner scanner4 = new Scanner(System.in);
        String state = scanner4.nextLine();

        int result = 0;

        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu_query.xml"));

            pstmt = con.prepareStatement(props.getProperty("insertMenu"));
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, category);
            pstmt.setString(4, state);

            result = pstmt.executeUpdate();
            System.out.println("결과 : " + result);
            if (result == 1){
                System.out.println("메뉴등록이 완료되었습니다.");
            } else {
                System.out.println("다시 등록해 주세요");
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
