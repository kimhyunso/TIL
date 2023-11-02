package programmers.컨트롤제트;

/**
 * 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다. 
 * 문자열에 있는 숫자를 차례대로 더하려고 합니다. 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
 * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 
 * 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
 */
/**
 * 풀이법 : 
 * str을 `split()`함수를 통해 쪼갠 후, 만들어진 배열을 가지고 반복
 * 1. 만약 배열 안에 Z가 있을 경우 : 전체(answer)에서 전에 있는 값을 뺌
 * 2. 배열 안에 Z가 없을 경우 : 값을 누적해나감
 */

public class Main {
    public static void main(String[] args){
        String str = "1 2 Z 3";
        solution(str);
    }


    public static int solution(String s){
        String str[] = s.split(" ");
        int answer = Integer.parseInt(str[0]);

        for (int i=1; i<str.length; i++){
            String target = str[i];

            if (target.equals("Z"))
                answer -= Integer.parseInt(str[i-1]);
            else
                answer += Integer.parseInt(str[i]);
        }



        return answer;
    }
}
