package programmers.완주하지못한선수;

/**
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. 
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
 * 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */

/**
 * getOrDefault()함수 : key와 defaultValue를 받는다.
 * 찾을 데이터의 키, 기본으로 정할 값
 */

 /**
  * 풀이법 : HashMap 사용
  * 초기화 단계 : participant[i]와 HashMap의 getOrDefault()함수를 사용하여 선수들 이름마다 +1씩 증가
  * 만약, HashMap에 completion 선수들이 포함되어 있다면 숫자를 감소시켜 0으로 만듬
  * 0이 아닌 데이터를 추출하여 반환
  */




import java.util.*;

public class Main {

    public static void main(String[] args){
        
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        solution(participant, completion);
    }

    public static String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> personList = new HashMap<String, Integer>(); 
        
        for (int i=0; i<participant.length; i++){
            personList.put(participant[i], personList.getOrDefault(participant[i], 0) + 1);    
        }
    
        for (int i=0; i<completion.length; i++){
            if (personList.containsKey(completion[i])){
                personList.put(completion[i], personList.get(completion[i])-1);                
            }
                
        }
           

        for (String key : personList.keySet()) {
            if (personList.get(key) != 0)
                answer += key;
            
        }
                
        
        return answer;
    }


    
}
