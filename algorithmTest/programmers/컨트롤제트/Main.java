package programmers.컨트롤제트;

import java.util.*;

public class Main {
    public static void main(String[] args){
        String str = "1 2 Z 3";
        solution(str);
    }


    public static int solution(String s){
        String str[] = s.split(" ");
        int answer = Integer.parseInt(str[0]);

        for (int i=1; i<str.length; i++){
            String target = str[i];

            if (target.equals("Z"))
                answer -= Integer.parseInt(str[i-1]);
            else
                answer += Integer.parseInt(str[i]);

            
        }

        


        return answer;
    }
}
