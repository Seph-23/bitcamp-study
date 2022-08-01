package com.bitcamp.util;

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.append("유관순");
    list.append("홍길동");
    list.append("안중근");
    list.append("임꺽정");
    list.append("유성민");

    Object[] arr = list.getArray();
    for(int i=0; i<list.length(); i++) {
      System.out.println(arr[i]);
    }
  }

  static void printList(LinkedList list) {
    System.out.println("----------------");
    for(int i=0; i<list.length(); i++) {
      System.out.println(list.retrieve(i));
    }
  }

}