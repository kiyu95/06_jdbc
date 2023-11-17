package com.ohgiraffers.restaurant.view;

import com.ohgiraffers.restaurant.controller.MenuCtr;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVo;
import com.ohgiraffers.restaurant.service.MenuService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuView {

    // view 계층을 예시로 만듬
    // 이후 해당 페이지는 html로 변경된다.
    public static void runApplication(){

        // 1. 사용자가 원하는 기능을 선택함
        // 2. 기능에 따라 동작됨
        Scanner scanner = new Scanner(System.in);
        MenuCtr menuCnt = new MenuCtr(new MenuService("src/main/resources/mapper/menu_query.xml"));

        loop : while (true){
            System.out.println("메뉴 관리 프로그램입니다.");
            System.out.println(" 1. 조회 \n 2. 수정 \n 3. 등록 \n 4. 삭제");
            System.out.println("원하는 기능을 입력해주세요");
            // 1. 사용자가 원하는 기능을 선택함
            int step = scanner.nextInt();

            // 2. 기능에 따라 동작됨
            switch (step){
                // 2-1 : 메뉴 조회
                case 1 : viewMenu(menuCnt.findAllMenu()); break;

                // 2-2 : 메뉴 수정
                case 2 : break;

                // 2-3 : 메뉴 등록
                case 3 : System.out.println(menuCnt.registMenu(registMenu())); break;

                // 2-4 : 메뉴 삭제
                case 4 : break;

                // default : 프로그램 종료
                default : break loop;
            }


        }

    }

    public static void viewMenu(List<MenuVo> menuList){
        if (Objects.isNull(menuList) ){
            System.out.println("조회 중 오류가 발생됨.");
        } else if (menuList.size() < 0) {
            System.out.println("등록된 메뉴가 없습니다.");
        } else {
            for (MenuVo menu : menuList){
                System.out.println(menu);
            }
        }
    }

    public static MenuDTO registMenu(){
        MenuDTO newMenu = new MenuDTO();
        Scanner sc = new Scanner(System.in);
        System.out.println("================");
        System.out.println();
        System.out.print("등록할 메뉴 이름을 입력해주세요 : ");
        newMenu.setMenuName(sc.nextLine());
        System.out.println("가격을 입력해주세요 : ");
        newMenu.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.println("카테고리 코드를 입력해주세요 : ");
        newMenu.setCategory(sc.nextLine());
        System.out.println("판매여부를 입력해주세요 : ");
        newMenu.setStatus(sc.nextLine());

        // 일반적으로 front에서 js를 이용하여 1차 유효성 검사를 진행한다.

        return newMenu;

    }



}
