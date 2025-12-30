package com.jinosoft.run;

import com.jinosoft.service.ElementTestService;

import java.util.Scanner;

/**
 * Main application class to run the MyBatis Mapper Element tests.
 * MyBatis Mapper Element 테스트를 실행하는 메인 어플리케이션 클래스입니다.
 */
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        // 무한 루프를 통해 사용자가 원하는 테스트 메뉴를 선택할 수 있도록 합니다.
        do {
            System.out.println("===== Mapper Element 테스트 (ResultMap 테스트) =====");
            System.out.println("1. <resultMap> 테스트 ");
            System.out.println("2. <association> 테스트 ");
            System.out.println("3. <collection> 테스트 ");
            System.out.print("메뉴 번호 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    elementTestService.selectResultMapTest();
                    break;
                case 2:
                    elementTestService.selectResultMapAssociationTest();
                    break;
                case 3:
                    elementTestService.selectResultMapCollectionTest();
                    break;
                default:
                    System.out.println("잘못 된 번호를 입력하셨습니다.");
            }
        } while (true);
    }
}