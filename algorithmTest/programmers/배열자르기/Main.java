package programmers.배열자르기;

/**
 * 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때, 
 * numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.
 */

/**
 * 풀이법 : 
 * Arrays.copyOfRange(배열, 시작, 끝-1) 사용
 * nums = [1, 2, 3, 4, 5] => Arrays.copyOfRange(nums, 1, 3) => [2, 3]
 */


import java.util.*;

public class Main {
    public static void main(String args[]){
        int []numbers = {1, 2, 3, 4, 5};
        int n[] = {1, 2, 3, 4, 5};
        int num1 = 1, num2 = 3;

        for(int result : solution(numbers, num1, num2)){
            System.out.println(result);
        } 
    }
    
    public static int[] solution(int[] numbers, int num1, int num2){
        return Arrays.copyOfRange(numbers, num1, num2+1);
    }
}
