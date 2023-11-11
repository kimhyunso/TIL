package fastcampus.대소문자바꾸기_2744;

/**
 * 1. 아이디어
 * - for문을 돌면서 소문자인지 대문자인지 확인 후
 * - 소문자 : ('a' - 현재 문자) + 'A'
 * - 대문자 : ('A' - 현재문자) + 'a'
 * 2. 시간복잡도
 * - 문자열 길이만큼, 최대길이 : 100
 * - O(N) > 가능
 * 3. 자료구조
 * - 받은 문자열 String
 * 
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // char[] answer = line.toCharArray();
        String answer = "";
        String line = input.readLine();

        for (int i=0; i<line.length(); i++){
            char lineToChar = line.charAt(i);
            // 소문자
            if (lineToChar >= 'a' && lineToChar <= 'z'){
                // 소문자에서 현재문자를 빼고 대문자를 더해줌
                answer += (char)((lineToChar - 'a') + 'A');
                
            }
            // 대문자
            else if (lineToChar >= 'A' && lineToChar <= 'Z'){
                // 대문자에서 현재문자를 빼고 소문자를 더해줌
                answer += (char)((lineToChar - 'A') + 'a');
            }
        }
        System.out.println(answer);
    }
    
}
