package programmers.문자열내림차순으로배치하기;

import java.util.*;

public class Main {
    public static void main(String[] args){
        String str = "bDdsfweWaA";
        System.out.println(solution(str));
    }

    public static String solution(String s){

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);

        String answer = "";
        // 65 A 97 a
        int right = s.length()-1;
        int left = 0;
        
        while (left <= right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);


            

            
            if (leftChar < rightChar){
                answer += String.valueOf(rightChar);
                right --;
            }else if (leftChar > right){
                answer += String.valueOf(leftChar);
                left ++;
            }
        }
    
        return answer;
    }
}
