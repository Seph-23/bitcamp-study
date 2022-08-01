package com.bitcamp.util;

/**
 * linked list의 각 항목의 값을 저장 할 클래스.
 * @author seph
 * 
 */
public class Node {
  Object value;
  Node prev;
  Node next;

  public Node() {}

  public Node(Object value) {
    this.value = value;
  }

}
