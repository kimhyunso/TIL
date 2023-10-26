package programmers.시저암호;

public class Main {
    public static void main(String[] args){
        String str = "e F d A B G";
        int n = 4;
        System.out.println(solution(str, n));
    }

    public static String solution(String s, int n){
        String answer = "";

        for (int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            
            if (temp == ' ')
                answer += " ";
            else{
                if(temp >= 'a' && temp <= 'z'){
                    if (temp + n > 'z')
                        answer += (char) (temp-26+n);
                    else
                        answer += (char) (temp + n);


                }else if (temp >= 'A' && temp <= 'Z'){
                    if (temp + n > 'Z')
                        answer += (char) (temp-26+n);
                    else
                        answer += (char) (temp + n);

                }
            }            
        }

        return answer;
    }
}
