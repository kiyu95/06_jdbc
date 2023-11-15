package com.ohgiraffers.section02.template;

import java.sql.Connection;
import com.ohgiraffers.section02.template.JDBCTemplate; // static 메서드 import하기
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection; // static 메서드 import하기
import static com.ohgiraffers.section02.template.JDBCTemplate.close; // static 메서드 import하기

public class Application01 {
    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println(con);
        close(con);
    }
}
