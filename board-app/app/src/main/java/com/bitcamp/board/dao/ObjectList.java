package com.bitcamp.board.dao;

public class ObjectList {
  private static final int DEFAULT_SIZE = 3;

  protected int length; 
  protected Object[] list;

  public ObjectList() {
    this.list = new Object[DEFAULT_SIZE];
  }

  public ObjectList(int initCapacity) {
    this.list = new Object[initCapacity];
  }

  //목록에 저장된 인스턴스를 꺼내서 리턴한다.
  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public Object get(int index) {
    if(index < 0 || index >= this.length) {
      return null;
    }
    return list[index]; 
  }

  public void add(Object obj) {
    if (this.length == this.list.length) {
      grow();
    }
    this.list[this.length++] = obj;
  }

  public boolean remove(int index) {
    if(index < 0 || index >= this.length) {
      return false;
    }
    // 삭제할 항목의 다음 항목을 앞으로 당긴다.
    for (int i = index + 1; i < this.length; i++) {
      this.list[i - 1] = this.list[i];
    }
    // 리스트 개수를 한 개 줄인 후 
    // 맨 뒤의 있던 항목의 주소를 0으로 설정한다.
    this.list[--this.length] = null;

    return true;
  }

  private void grow() {
    int newSize = this.list.length + (this.list.length >> 1);
    Object[] newArray = new Object[newSize];
    for (int i = 0; i < this.list.length; i++) {
      newArray[i] = this.list[i];
    }
    this.list = newArray;
  }
}