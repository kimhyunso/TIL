package programmers.문자열이몇번등장하는지세기;

/**
 * 문자열 myString과 pat이 주어집니다.
 * myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.
 */

/**
 * 풀이법 : 
 * myString = "banana", pat = "ana"
 * 1번째 루프
 * 0 ~ 3-1 [ban] : ana가 포함되어있는지 판단
 * 
 * 2번째 루프
 * 1 ~ 4-1 [ana] : ana가 포함되어있는지 판단
 * 
 * 3번째 루프
 * 2 ~ 5-1 [nan] : ana가 포함되어있는지 판단
 * 
 * 4번째 루프
 * 3 ~ 6-1 [ana] : ana가 포함되어있는지 판단
 * 루프 종료 끝까지 다비교함
 */



public class Main {
    public static void main(String[] args){
        String myString = "banana";
        String pat = "ana";
        solution(myString, pat);
    }


    public static int solution(String myString, String pat){
        int answer = 0;
        int patIdx = pat.length();

        for (int i=0; i<=myString.length()-pat.length(); i++){
            if (myString.substring(i, patIdx).contains(pat)) answer ++;
            patIdx++;
        }

        return answer;
    }
}
