/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board;

import java.util.Date;

public class BoardHandler {
  static final int DEFAULT_SIZE = 3;

  int boardCount = 0; // 저장된 게시글의 개수
  Board[] boards = new Board[DEFAULT_SIZE];
  String title = "";

  public BoardHandler(String title){
    this.title = title;
  }

  void execute() {
    while(true) {         //게시판
      System.out.println(this.title + ":");
      System.out.println("  1: 목록");
      System.out.println("  2: 상세보기");
      System.out.println("  3: 등록");
      System.out.println("  4: 삭제");
      System.out.println("  5: 변경");
      System.out.println();
      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");
      displayHeadLine();
      switch(menuNo){
        case 0: return;
        case 1: this.processList(); break;
        case 2: this.processDetail(); break;
        case 3: this.processInput(); break;
        case 4: this.processDelete(); break;
        case 5: this.processUpdate(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      }
      displayBlankLine();
    }
  }

  static void displayHeadLine(){
    System.out.println("--------------------------------------");
  }

  static void displayBlankLine(){
    System.out.println(); // 메뉴를 처리한 후 빈 줄 출력
  }

  void processList() {
    // 날짜 정보에서 값을 추출하여 특정 포맷의 문자열로 만들어줄 도구를 준비
    java.text.SimpleDateFormat formatter = 
        new java.text.SimpleDateFormat("yyyy-MM-dd");

    System.out.println("[" + this.title + " 목록]");
    System.out.println("번호 제목 조회수 작성자 등록일");

    for (int i = 0; i < this.boardCount; i++) {
      Board board = boards[i];

      // 밀리초 데이터 ==> Date 도구함으로 날짜 정보를 설정
      Date date = new Date(board.createdDate);

      // 날짜 정보 ==> "yyyy-MM-dd" 형식의 문자열
      String dateStr = formatter.format(date); 

      System.out.printf("%d\t%s\t%d\t%s\t%s\n",
          board.no, board.title, board.viewCount, board.writer, dateStr);
    }
  }

  void processDetail() {
    System.out.println("[" + this.title + " 상세보기]");

    int boardNo = Prompt.inputInt("조회할 게시글 번호? ");

    // 해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    Board board = null;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        board = this.boards[i];
        break;
      }
    }

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("작성자: %s\n", board.writer);
    Date date = new Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
  }

  void processInput() {
    System.out.println("[" + this.title + " 등록]");

    // 배열의 크기를 초과하면 배열 크기를 50% 증가 시킨다.
    if (this.boardCount == this.boards.length) {
      // 새로 만들 배열의 크기 계산
      int newSize = this.boards.length + (this.boards.length >> 1);
      Board[] newArray = new Board[newSize];

      for(int i=0; i<this.boards.length; i++) {
        newArray[i] = this.boards[i];
      }

      this.boards = newArray;
    }

    Board board = new Board();

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.password = Prompt.inputString("암호? ");

    board.no = this.boardCount == 0 ? 1 : this.boards[this.boardCount - 1].no + 1;
    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis();

    // 새로 만든 인스턴스 주소를 레퍼런스 배열에 저장한다.
    this.boards[this.boardCount] = board;

    this.boardCount++;
  }

  void processDelete() {
    //    Board board = null;

    System.out.println("[" + this.title + " 삭제]");

    String input = Prompt.inputString("삭제 게시글 번호? ");
    int boardNo = Integer.parseInt(input);

    // 해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    int boardIndex = -1;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        boardIndex = i;
        break;
      }
    }

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (boardIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    // 삭제할 게시글의 다음 항목을 앞으로 당긴다.
    for (int i = boardIndex + 1; i < boardCount; i++) {
      boards[i - 1] = boards[i];
    }

    // 게시글 개수를 1개 줄이고 맨 마지막 레퍼런스는 null 로 비운다.
    boards[--boardCount] = null;

    System.out.println("삭제하였습니다.");
  }

  public void processUpdate() {
    String titleTemp, contentTemp;

    System.out.println("[" + this.title + " 변경]");

    int boardNo = Prompt.inputInt("변경할 게시글 번호? ");

    // 해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    int boardIndex = -1;
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        boardIndex = i;
        break;
      }
    }

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (boardIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }else {
      titleTemp = Prompt.inputString("제목?(" + boards[boardIndex].title + ")");
      contentTemp = Prompt.inputString("내용?(" + boards[boardIndex].content + ")");
    }

    String yesOrNo = Prompt.inputString("변경하시겠습니까? (y/n)");

    if(yesOrNo.equals("y")) {
      boards[boardIndex].title = titleTemp;
      boards[boardIndex].content = contentTemp;
    }else {
      System.out.println("변경 취소했습니다.");
    }
  }
}