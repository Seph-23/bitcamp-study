package com.bitcamp.util;

/**
 * Node 클래스를 사용해 값의 목록을 관리하는 클래스.
 * @author seph
 *
 */
public class LinkedList {
  private Node head;        //첫 노드의 주소를 저장.
  private Node tail;        //마지막 노드의 주소를 저장.
  private int size;         //저장된 데이터 갯수.

  /**
   * 파라미터로 주어진 값을 노드에 담아 리스트에 연결.
   * @param value
   */
  public void append(Object value) {
    //Node 생성 후 값을 저장.
    Node node = new Node(value);
    size++;

    if(tail == null) {
      head = tail = node;
      return;
    }
    tail.next = node;       //노드 끝에 새 노드를 연결한다.
    node.prev = tail;       //새 노드가 현재의 끝 노드를 가리키게 한다.

    tail = node;            //새 노드가 끝 노드가 되게 설정.
  }

  public Object retrieve(int index) {
    if(index < 0 || index > size) {
      throw new ListException();
    }
    Node node = head;
    for(int i=0; i<index; i++) {
      node = node.next;
    }
    return node.value;
  }

  public Object delete(int index) {
    if(index < 0 || index > size) {
      throw new ListException();
    }
    Node node = head;
    for(int i=0; i<index; i++) {
      node = node.next;
    }
    size--;
    Object deleted;

    if(head == tail) {          //마지막 남은 노드 삭제.
      deleted = head.value;
      head.value = null;
      head = tail = null;
      return deleted;
    }
    if(node.prev != null) {     
      node.prev.next = node.next;
    } else {                    //첫번째 노드 삭제.
      head = node.next;
      head.prev = null;
    }
    if(node.next != null) {     
      node.next.prev = node.prev;
    } else {                    //마지막 노드 삭제.
      tail = node.prev;
      tail.next = null;
    }

    //삭제하는 노드 초기화.  
    deleted = node.value;
    node.value = node.prev = node.next = null;
    return deleted;
  }

  public Object[] getArray() {
    Object[] arr = new Object[length()];
    Node node = head;
    for(int i=0; i<length(); i++) {
      arr[i]= node.value;
      node = node.next;
    }
    return arr;
  }

  public int length() {
    return size;
  }
}