package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Member;
import com.bitcamp.util.ObjectList;

// 회원 목록을 관리하는 역할
//
public class MemberDao {

  ObjectList list = new ObjectList();

  public void insert(Member member) {
    list.add(member);
  }

  public Member findByEmail(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = (Member) list.get(i);
      if (member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }

  public boolean delete(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = (Member) list.get(i);
      if (member.email.equals(email)) {
        return list.remove(i);
      }
    }
    return false;
  }

  public Member[] findAll() {
    Object[] arr = list.toArray();
    Member[] members = new Member[arr.length];
    for(int i=0; i<arr.length; i++) {
      members[i] = (Member) arr[i]; 
    }
    return members;
  }
}