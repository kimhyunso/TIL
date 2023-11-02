package programmers.옹알이;
/**
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 
 * 연속해서 같은 발음을 하는 것을 어려워합니다. 
 * 문자열 배열 babbling이 매개변수로 주어질 때, 
 * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

/**
  * 풀이법 : 
  * 한 단어모음에서 중복된 단어가있다면 1로 바꾸고
  * 중복된 단어가 없다면 " "로 바꾸어 trim(공백제거) 후 길이가 0일 경우 count를 증가시킨다.
  *
  */

public class Main {
    public static void main(String[] args){
        String babbling[] = {"ayayeayaaya"};

        System.out.println(solution(babbling));
    } 

    public static int solution(String[] babbling){
        
        int answer = 0;

        String words[] = {"aya", "ye", "woo", "ma"};
        String duplicatedWord[] = {"ayaaya", "yeye", "woowoo", "mama"};

        for (int i=0; i<babbling.length; i++){
            String word = babbling[i];
            for (int j=0; j<words.length; j++){
                word = word.replace(duplicatedWord[j], "1");
                word = word.replace(words[j], " ");                    
            }

            if (word.trim().length() == 0)
                answer ++;

        }
        
        return answer;
    }
}
