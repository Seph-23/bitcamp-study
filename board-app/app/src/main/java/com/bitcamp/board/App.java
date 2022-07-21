/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class App {

  public static void main(String[] args) {
    welcome();
    loop:
      while (true) {
        //메인 메뉴 출력
        System.out.println("메뉴:");
        System.out.println("  1: 게시판");
        System.out.println("  2: 독서록");
        System.out.println("  3: 방명록");
        System.out.println("  4: 공지사항");
        System.out.println();
        int mainMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..4](0: 종료) ");
        switch(mainMenuNo){
          case 0: break loop;
          case 1: 
            BoardHandler.execute();
            break;
          case 2: break;               //독서록
          case 3: break;               //방명록
          case 4: break;               //공지사항
          default: System.out.println("메뉴 번호가 옳지 않습니다!");
        }
      } // while
    System.out.println("안녕히 가세요!");
    Prompt.close();
  }

  static void welcome(){
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }
}
