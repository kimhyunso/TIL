package programmers.이_의영역;
/*
정수 배열 arr가 주어집니다. 
배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 
solution 함수를 완성해 주세요.

단, arr에 2가 없는 경우 [-1]을 return 합니다.
 */


/*
풀이법 : 
첫번째 인덱스와 마지막 인덱스를 갖고 배열을 재구성한다.
 */
import java.util.*;
import java.io.*;

public class 이_의영역 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer splitInput = new StringTokenizer(input.readLine(), " ");
        int arr[] = new int[splitInput.countTokens()];
        for (int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(splitInput.nextToken());
        }

        solution(arr);
    }

    public static int[] solution(int[] arr){
        int[] answer = {};
        // 시작인덱스
        int firstIndex = 0;
        // 마지막 인덱스
        int lastIndex = 0;

        for (int i=0; i<arr.length; i++){
            if (arr[i] == 2){
                firstIndex = i;
                break;
            }
        }

        for (int i=arr.length-1; i>=0; i--){
            if (arr[i] == 2){
                lastIndex = i;
                break;
            }
        }

        if (lastIndex == 0 && firstIndex == 0){
            int result[] = {-1};
            answer = result;
        }else
            answer = Arrays.copyOfRange(arr, firstIndex, lastIndex+1);

        return answer;
    }

}
