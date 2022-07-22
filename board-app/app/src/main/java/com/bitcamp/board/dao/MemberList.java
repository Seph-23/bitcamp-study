package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Member;

// 회원 목록을 관리하는 역할
//
public class MemberList extends ObjectList{
  private int no = 0; 

  @Override
  public Member get(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member member = (Member) this.list[i];
      if (member.no == memberNo) {
        return member;
      }
    }
    return null;
  }

  @Override
  public void add(Object obj) {
    Member member = (Member) obj;
    member.no = nextNo();
    super.add(member);
  }

  @Override
  public boolean remove(int memberNo) {
    int memberIndex = -1;
    for (int i = 0; i < this.length; i++) {          //super 를 쓰는게 더 직관적이지 않은가? 실무에서는 어떤게 더 적합한가? 어차피 실무에서는 둘다 생략?
      Member member = (Member) this.list[i];
      if (member.no == memberNo) {
        memberIndex = i;
        break;
      }
    }
    return super.remove(memberIndex);
  }

  private int nextNo() {
    return ++no;
  }
}