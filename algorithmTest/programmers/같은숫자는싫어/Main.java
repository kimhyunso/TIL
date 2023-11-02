package programmers.같은숫자는싫어;
/**
 * 
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 */

/**
 * 풀이법 : Stack 이용
 * Stack이 비어있다면 무조건 push, 비어있지 않다면 현재 Stack에 있는 내용물이 비교대상과 같은지 비교 후 push
 * 
 */


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
