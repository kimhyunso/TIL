package programmers.시저암호;


/**
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
 * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. 
 * "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 */

/**
 * 풀이법 : 
 * 문자열 s를 `charAt()`을 사용하여 char로 분리 후, 분리된 char(temp)를 이용해 공백인지 체크
 * 1. 공백일 경우 : answer에 공백 추가
 * 2. 공백이 아닌 경우 : 
 * 2-1. 소문자인 경우 : 
 * 2-1-1. (temp + n)이 z보다 큰 경우 : (temp-26+n) 알파벳이 26개이기 때문에 temp에서 26을 빼고, n만큼을 더한다.
 * 2-1-1. (temp + n)이 z보다 작은 경우 : (temp + n) temp를 n만큼 더한다.
 * 2-2. 대문자인 경우 : 
 * 2-2-1. (temp + n)이 Z보다 큰 경우 : (temp-26+n) 알파벳이 26개이기 때문에 temp에서 26을 빼고, n만큼을 더한다.
 * 2-2-2. (temp + n)이 Z보다 작은 경우 : (temp + n) temp를 n만큼 더한다.
 */


public class Main {
    public static void main(String[] args){
        String str = "e F d A B G";
        int n = 4;
        System.out.println(solution(str, n));
    }

    public static String solution(String s, int n){
        String answer = "";

        for (int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            
            if (temp == ' ')
                answer += " ";
            else{
                if(temp >= 'a' && temp <= 'z'){
                    if (temp + n > 'z')
                        answer += (char) (temp-26+n);
                    else
                        answer += (char) (temp + n);


                }else if (temp >= 'A' && temp <= 'Z'){
                    if (temp + n > 'Z')
                        answer += (char) (temp-26+n);
                    else
                        answer += (char) (temp + n);
                }
            }            
        }

        return answer;
    }
}
