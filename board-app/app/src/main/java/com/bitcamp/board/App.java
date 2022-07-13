/*
 * 게시판 관리 애플리케이션
 * 비트캠프 2022-07-04
 */
package com.bitcamp.board;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
  public static void main(String[] args) {
    //Variable Declaration
    Scanner sc = new Scanner(System.in);
    Date date;

    int menuNo = 0;

    final int SIZE = 3;
    String[] title = new String[SIZE];
    String[] password = new String[SIZE];
    String[] writer = new String[SIZE]; 
    String[] content = new String[SIZE];
    int[] viewCount = new int[SIZE];
    long[] createdDate = new long[SIZE];
    int[] no = new int[SIZE];

    int boardCount = 0;                 //저장된 게시글 갯수

    while(true){
      System.out.println("메뉴:");
      System.out.println("  1: 게시글 목록");
      System.out.println("  2: 게시글 상세보기");
      System.out.println("  3: 게시글 등록");
      
      System.out.print("\n메뉴를 선택하세요[1..3]: (0:종료)");
      menuNo = sc.nextInt();
      sc.nextLine();
      System.out.println();

      if(menuNo==0){
        System.out.println("안녕히가세요!");
        break;
      }

      // while(menuNo<1 || menuNo>2){
      //   System.out.print("1에서 2사이의 메뉴 번호를 입력하세요: ");
      //   menuNo = sc.nextInt();
      // }

      if(menuNo==1){        //모든 게시글 목록!!
        System.out.println("[게시글 목록]");
        System.out.println("번호 제목 조회수 작성자 등록일");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        
        for(int i=0; i<boardCount; i++){
          System.out.print((i+1) + "     " + title[i] + "     " + viewCount[i] + "     " + writer[i] + "    ");
          date = new Date(createdDate[i]);
          String dateStr = formatter.format(date);
          System.out.println(dateStr);
          // System.out.printf("%tY-%1$tm-%1$td-%1$tH:%1$tM\n", date);     //1$ 첫번째 데이터 계속 사용.
        }

      }else if(menuNo==2){    //게시판 조회하기!!
        System.out.println("[게시판 상세보기]");

        System.out.print("조회할 게시글 번호? ");
        String input = sc.nextLine();
        int boardNo = Integer.parseInt(input);
        boardNo--;                                      //조회 하고 싶은 게시글번호-1. 인덱스 넘버가 게시글 번호-1 이여서.

        if(boardNo < boardCount){
          viewCount[boardNo]++;

          System.out.printf("번호: %d\n", no[boardNo]);
          System.out.printf("제목: %s\n", title[boardNo]);
          System.out.printf("내용: %s\n", content[boardNo]);
          System.out.printf("조회수: %d\n", viewCount[boardNo]);
          System.out.printf("작성자: %s\n", writer[boardNo]);

          //Date 정보값 입력
          date = new Date(createdDate[boardNo]);
          System.out.printf("등록일: %tY-%1$tm-%1$td-%1$tH:%1$tM\n", date);     //1$ 첫번째 데이터 계속 사용.
        }else{
          System.out.println("!!!조회한 게시글이 없습니다!!!");
          continue;
        }

      }else if(menuNo==3){    //게시글 등록하기!!
        System.out.println("[게시글 등록]");

        if(boardCount == SIZE){
          System.out.println("더이상 게시글을 등록할 수 없습니다.");
          continue;
        }
      
        //등록할 게시글 정보 입력 받기.
        System.out.print("제목? ");
        title[boardCount] = sc.nextLine();
        System.out.print("내용? ");
        content[boardCount] = sc.nextLine();
        System.out.print("암호? ");
        password[boardCount] = sc.nextLine();
        System.out.print("작성자? ");
        writer[boardCount] = sc.nextLine();

        //게시글 번호, 조회수, 생성 날짜 initialize
        no[boardCount] = boardCount + 1;              //게시글 번호
        viewCount[boardCount] = 0;                    //게시글 조회수
        createdDate[boardCount] = System.currentTimeMillis();       //게시글 생성 날짜

        boardCount++;                                               //총 등록 게시글 갯수
      }else{
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }
      System.out.println();
    } 
    sc.close();
  }
}