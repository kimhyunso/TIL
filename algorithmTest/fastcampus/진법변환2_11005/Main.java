package fastcampus.진법변환2_11005;

import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int B = input.nextInt();

        String ans = "";

        while(N > 0){
            int D = N % B;
            if (D < 10) ans += D;
            else ans += (char)(D- 10 + 'A');
            N = N/B;
        }

        for (int i = ans.length()-1; i>=0; i--)
            System.out.println(ans.charAt(i));


    }
    
}
