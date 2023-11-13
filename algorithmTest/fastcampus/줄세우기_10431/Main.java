package fastcampus.줄세우기_10431;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCase = Integer.parseInt(input.nextLine());
        int numbers[] = new int[20];

        for(int i=0; i<testCase; i++){
            int T = Integer.parseInt(input.next());
            
            for (int j=0; j<20; j++){
                numbers[j] = Integer.parseInt(input.next());
            }

            int total = 0;

            for (int j=numbers.length-1; j>=0; j--){
                for (int k=j-1; k>=0; k--){
                    if (numbers[j] < numbers[k]){
                        total++;
                    }
                }
            }

            System.out.println(T + " " + total);

        }
    }
    
    
}
