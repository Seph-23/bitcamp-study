package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;

// 게시글 목록을 관리하는 역할
//
public class BoardList extends ObjectList {
  private int no = 0; 

  // 게시글 번호에 해당하는 Board 인스턴스를 찾아 리턴한다.
  @Override
  public Board get(int boardNo) {
    for (int i = 0; i < super.length; i++) {
      Board board = (Board) super.list[i];
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  @Override
  public void add(Object obj) {
    Board board = (Board) obj;
    board.no = nextNo();
    super.add(board);
  }

  @Override
  public boolean remove(int boardNo) {
    int boardIndex = -1;
    for (int i = 0; i < super.length; i++) {
      Board board = (Board) super.list[i];
      if (board.no == boardNo) {
        boardIndex = i;
        break;
      }
    }
    return super.remove(boardIndex);
  }

  private int nextNo() {
    return ++no;
  }
}