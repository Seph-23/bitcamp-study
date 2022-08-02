package com.bitcamp.util;

/**
 * 인덱스를 기반으로 목록을 관리하는 메서드의 규격을 정의.
 * @author seph
 *
 */
public interface List {
  void add(Object value);
  Object get(int index);
  Object remove(int index);
  Object[] toArray();
  int size();

}
