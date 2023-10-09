package programmers.왼쪽_오른쪽;

/*

문자열 리스트 str_list에는 "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다. 
str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를, 
먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return하도록 solution 함수를 완성해주세요. 

"l"이나 "r"이 없다면 빈 리스트를 return합니다.
 */

/*
풀이법 :
1. l 일 경우 : 0부터 현재 인덱스-1까지 배열을 만들어 리턴 
2. r 일 경우 : 현재인덱스 +1 부터 마지막인덱스까지 배열을 만들어 리턴
 */

import java.util.*;


class Main {

    public static void main(String[] args){
        String [] str_list = {"u", "u", "l", "r"};
        solution(str_list);
    }


    public static String[] solution(String[] str_list){
        String[] answer = {};


        for (int i=0; i<str_list.length; i++){
            if (str_list[i].equals("l")){
                answer = Arrays.copyOfRange(str_list, 0, i);
                break;
            }else if (str_list[i].equals("r")){
                answer = Arrays.copyOfRange(str_list, i+1, str_list.length);
                break;
            }
        }

        return answer;
    }
    
}
