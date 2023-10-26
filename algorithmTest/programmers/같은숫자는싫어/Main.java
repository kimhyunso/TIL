package programmers.같은숫자는싫어;

import java.util.*;

public class Main {
    public static void main(String[] args){

        int arr[] = {1, 1, 3, 3, 0, 1, 1};
        for (int result : solution(arr)){
            System.out.print(result);
        }

    }

    public static int[] solution(int []arr){
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i=0; i<arr.length; i++){
            int temp = arr[i];

            if (stack.isEmpty())
                stack.push(temp);
            else{
                if (stack.peek() != temp)
                    stack.push(temp);
            }
        }

        int answer[] = new int[stack.size()];

        for (int i=answer.length-1; i>=0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}
