package com.eomcs.quiz.ex01;

// 출처: codefights.com
//
// 숫자 배열에서 각 이웃하는 숫자간의 차가 가장 큰 것을 알아내기
// 예)
// [2, 4, 1, 0] => 3
// 

public class Test05 {
  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{2, 4, 1, 0}) == 3);
    System.out.println(maxDiff(new int[]{3, 1, 4, 3, 8, 7}) == 5);
  }

  static int maxDiff(int[] values) {
    int answer = Math.abs(values[0] - values[1]);
    int diff = 0;

    for(int i=1; i<values.length-1; i++) {
      diff = Math.abs(values[i] - values[i+1]);
      if(diff > answer) {
        answer = diff;
      }
    }

    return answer;
  }
}