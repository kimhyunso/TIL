package programmers.주사위게임1;
import java.lang.Math;


public class 주사위게임1 {
    public static void main(String[] args){
        int a = 3, b = 5;
        int answer = 0;

        if (a%2!=0 && b%2!=0)
            answer = (a * a) + (b * b);
        else if(a%2!=0 || b%2!=0)
            answer = 2 * (a + b);
        else
            answer = Math.abs(a - b);

        System.out.println(answer);
    }
}
