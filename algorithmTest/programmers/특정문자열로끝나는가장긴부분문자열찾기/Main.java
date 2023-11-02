package programmers.특정문자열로끝나는가장긴부분문자열찾기;
/**
 *문자열 myString과 pat가 주어집니다. 
 * myString의 부분 문자열중 pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.
 */

/**
 * 풀이법 :
 * 1. pat의 문자열 길이가 1이상일 경우 : myString에서 pat의 인덱스위치를 가져와 
 * (pat의 길이-1)를 더해준 것을 findIndex에 넣는다.
 * 2. 아닐 경우 즉, 문자열이 1개일경우 : myString에서 pat의 인덱스위치를 가져온 것을 findIndex에 넣는다.
 * substring을 이용해 0 - findIndex+1을 리턴한다.
 */

class Main {
    public static void main(String[] args){
        String myString = "AbCdEFG";
        String pat = "dE";


        System.out.println(solution(myString, pat));
    }

    public static String solution(String myString, String pat) {
        String answer = "";
        int findIndex = 0;
        int patLength = pat.length();
        if (patLength > 1)
            findIndex = myString.lastIndexOf(pat) + (patLength -1);
        else
            findIndex = myString.lastIndexOf(pat);
        
        answer = myString.substring(0, findIndex+1);
        
        return answer;

        /*String answer = "";
        // 3
        int idx = myString.lastIndexOf(pat);
        // [0 - 2] : AbC + dE
        answer = myString.substring(0, idx) + pat;

        return answer;*/
    }
}

