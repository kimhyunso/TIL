package programmers.수박수박수박수박수박수;

/**
 * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
 * 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 */

/**
 * 풀이법 :
 * n만큼 반복
 * 1. 짝수 일 경우 : answer에 "수"를 더함
 * 2. 홀수 일 경우 : answer에 "박"을 더함
 */


public class Main {
    public static void main(String[] args){
        int n = 3;
        System.out.println(solution(n));
    }

    public static String solution(int n){
        String answer = "";

        for (int i=0; i<n; i++){
            if (i%2 == 0){
                answer += "수";
            }else if (i%2 == 1){
                answer += "박";
            }
        }
        return answer;
    }
}
