package programmers.문자열뒤집기;

/**
 * 문자열 my_string이 매개변수로 주어집니다. 
 * my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
 */

/**
  * 풀이법 :
  * String을 toCharArray()를 통해 char 배열로 만든다.
  * (char 배열 / 2) 즉, char배열의 중앙값 만큼 반복하며
  * 첫번째 인덱스에 있는 char와 마지막 인덱스에 있는 char를 바꾼다.
  * new String()을 통해 answer에 할당한다.
  */


public class Main {
    public static void main(String[] args){
        String str = "jaron";
        solution(str);
    }

    public static String solution(String my_string){
        String answer = "";
        char strs[] = my_string.toCharArray();
        
        for (int i=0; i<strs.length/2; i++){
            char temp = strs[i];
            strs[i] = strs[(strs.length-1) - i];
             strs[(strs.length-1) - i] = temp;
        }
        
        answer = new String(strs);
        return answer;
    }
    
}
