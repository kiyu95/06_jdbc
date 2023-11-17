package com.ohgiraffers.section03;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application01 {
    public static void main(String[] args) {

        // transaction

        Connection con = getConnection();

        try {
            con.setAutoCommit(false); // aotoCommit 해제
//            insert 1

            con.commit(); // 쿼리가 정상적으로 작동했을때 commit
            System.out.println("autoCommit의 현재 값 : " + con.getAutoCommit());
        } catch (SQLException e) {
            try {
                con.rollback(); // 쿼리가 에러가 났을경우 롤백 처리함
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
