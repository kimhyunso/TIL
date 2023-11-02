package programmers.외계행성의나이;

/**
 * 우주여행을 하던 머쓱이는 엔진 고장으로 PROGRAMMERS-962 행성에 불시착하게 됐습니다. 
 * 입국심사에서 나이를 말해야 하는데, PROGRAMMERS-962 행성에서는 나이를 알파벳으로 말하고 있습니다. 
 * a는 0, b는 1, c는 2, ..., j는 9입니다. 
 * 예를 들어 23살은 cd, 51살은 fb로 표현합니다. 
 * 나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 return하도록 solution 함수를 완성해주세요.
 */

 /**
  * 풀이법 : 
  * int를 String으로 변환 후 split() 함수를 통해 쪼갠 후
  * 쪼갠 String을 Integer로 변환하고 + 'a'를 한 것을 answer에 축척한다.
  */


public class Main {
    public static void main(String[] args){
        int age = 23;
        System.out.println(solution(age));
    }

    public static String solution(int age){
        String answer = "";
        
        String arr[] = String.valueOf(age).split("");
        for (int i=0; i<arr.length; i++){
            answer += String.valueOf((char)(Integer.parseInt(arr[i]) + 'a'));
        }

        return answer;

    }
    
}
