package programmers.문자열겹쳐쓰기;

/**
 * 문자열 my_string, overwrite_string과 정수 s가 주어집니다. 
 * 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
 */


/**
 * 풀이법 :
 * 인덱스 0부터 s까지 문자열을 자른 후, overwrite_string을 더한다. 
 * ex) He11oWor1d => answer = He + lloWorl 
 * 만약 answer에 길이가 my_string 갈이보다 작다면, 마지막 문자열을 더한다.
 * 
 */


public class Main {
    public static void main(String[] args){
        String str = "He11oWor1d";
        int s = 2;
        String overwrite = "lloWorl";

        solution(str, overwrite, s);
    }

    public static String solution(String my_string, String overwrite_string, int s){
        String answer = my_string.substring(0, s) + overwrite_string;

        if(my_string.length() > answer.length()) {
            answer += my_string.substring(answer.length());
        }
        
        return answer;
    }
    
}
