package programmers.없는숫자더하기;

import java.util.*;

public class Main {
    public static void main(String[] args){

        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers){
        int answer = -1;
        int sum = 0;
        Arrays.sort(numbers);

        for (int i=0; i<=9; i++){
            sum += i;
        }

        for (int i=0; i<numbers.length; i++){
            answer += numbers[i];            
        }

        return sum - answer;
    }
    
}
