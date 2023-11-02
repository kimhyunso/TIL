package programmers.없는숫자더하기;

/**
 * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
 * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 */

/**
 * 풀이법 : 
 * 0~9까지 더한다. (sum)
 * answer에 배열로 들어온 모든 수들을 더한다.
 * sum에서 answer를 뺀다.
 */

import java.util.*;

public class Main {
    public static void main(String[] args){

        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers){
        int answer = -1;
        int sum = 0;
       

        for (int i=0; i<=9; i++){
            sum += i;
        }

        for (int i=0; i<numbers.length; i++){
            answer += numbers[i];            
        }

        return sum - answer;
    }
    
}
