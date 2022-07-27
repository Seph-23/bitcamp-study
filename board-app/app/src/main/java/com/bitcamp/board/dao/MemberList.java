package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Member;
import com.bitcamp.util.ObjectList;

// 회원 목록을 관리하는 역할
//
public class MemberList extends ObjectList {

  public Member get(String email) {         //이메일로 회원 정보 검색.
    for(int i = 0; i < size(); i++) {
      Member member = (Member) super.get(i);
      if(member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }

  public boolean remove(String email) {     //이메일로 회원 정보 삭제.
    for (int i = 0; i < size(); i++) {
      Member member = (Member) super.get(i);
      if (member.email.equals(email)) {
        return super.remove(i);
      }
    }
    return false;
  }
}














