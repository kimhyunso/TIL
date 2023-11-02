package programmers.문자열내림차순으로배치하기;

/**
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 */

 /**
  * 풀이법 :
  * 문자열을 `toCharArray()`라는 함수를 통해 char배열로 만든 후 정렬(Arrays.sort)한다.
  * 정렬한 문자를 다시 s에 할당 후
  * 첫번째 문자열과 마지막 문자열을 비교한다.
  * 반복 (left 가 right보다 작거나 클 때까지) :: left가 right보다 커진다면 반복문 중단
  * 1. 첫번째 문자열이 클 경우 : 
  * answer라는 문자열에 할당 후 left(첫번째 문자열 인덱스)를 +1한다.
  * 2. 마지막 문자열이 클 경우 : 
  * answer라는 문자열에 할당 후 right(마지막 문자열 인덱스)를 -1한다.
  */

import java.util.*;

public class Main {
    public static void main(String[] args){
        String str = "bDdsfweWaA";
        System.out.println(solution(str));
    }

    public static String solution(String s){

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);

        String answer = "";
        // 65 A 97 a
        int right = s.length()-1;
        int left = 0;
        
        while (left <= right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            
            if (leftChar < rightChar){
                answer += String.valueOf(rightChar);
                right --;
            }else if (leftChar > right){
                answer += String.valueOf(leftChar);
                left ++;
            }
        }
    
        return answer;
    }
}
