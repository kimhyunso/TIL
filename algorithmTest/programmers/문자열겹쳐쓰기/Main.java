package programmers.문자열겹쳐쓰기;

public class Main {
    public static void main(String[] args){
        String str = "He11oWor1d";
        int s = 2;
        String overwrite = "lloWorl";

        solution(str, overwrite, s);
    }

    public static String solution(String my_string, String overwrite_string, int s){
        String answer = my_string.substring(0, s) + overwrite_string;

        if(my_string.length() > answer.length()) {
            answer += my_string.substring(answer.length());
        }
        
        return answer;
    }
    
}
