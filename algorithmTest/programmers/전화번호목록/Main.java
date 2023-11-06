package programmers.전화번호목록;

/**
 * 전화번호부에 적힌 전화번호 중, 
 * 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 
 * 하도록 solution 함수를 작성해주세요.
 */

 /**
  * 풀이법 : HashSet 이용
  * 초기화 : HashSet에 중복 불가한 데이터 추가
  * HashSet에 데이터 하나를 가져와 길이만큼 자르면서 HashSet에 데이터가 있는지 비교
  * ex) ["119", "97674223", "1195524421"]
  * 1번째 "119"를 가져왔다 가정하자면,
  * 1번째루프 : set.contains("")
  * 2번째루프 : set.contains("1")
  * 3번째루프 : set.contains("11")
  * 3번째 "1195524421"를 가져왔다 가정하자면,
  * 1번째루프 : set.contains("")
  * 2번째루프 : set.contains("1")
  * 3번째루프 : set.contains("11")
  * 4번째루프 : set.contains("119") ==> return false
  */




import java.util.*;

public class Main {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        solution(phone_book);
    }

    public static boolean solution(String[] phone_book){
        boolean answer = true;
        HashSet<String> set = new HashSet<String>();
        for (String phone : phone_book){
            set.add(phone);
        }

        for (String phone : phone_book){
            for (int i=0; i<phone.length(); i++){
                if (set.contains(phone.substring(0, i)))
                    return false;
            }
        }

        return answer;
    }
    
}
