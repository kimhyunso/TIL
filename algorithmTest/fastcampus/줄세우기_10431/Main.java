package fastcampus.줄세우기_10431;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);

        // int testCase = Integer.parseInt(input.nextLine());
        // int numbers[] = new int[20];

        // for(int i=0; i<testCase; i++){
        //     int T = Integer.parseInt(input.next());
            
        //     for (int j=0; j<20; j++){
        //         numbers[j] = Integer.parseInt(input.next());
        //     }

        //     int total = 0;

        //     for (int j=numbers.length-1; j>=0; j--){
        //         for (int k=j-1; k>=0; k--){
        //             if (numbers[j] < numbers[k]){
        //                 total++;
        //             }
        //         }
        //     }

        //     System.out.println(T + " " + total);

        // }


        solution();
    }



    public static void solution(){
        Scanner input = new Scanner(System.in);

        int P = input.nextInt();
        while (P-- > 0){
            int T = input.nextInt();

            int[] h = new int[20];

            for (int i=0; i<20; i++){
                h[i] = input.nextInt();
            }


            int cnt = 0;
            int[] sorted = new int[20];

            for (int i=0; i<20; i++){
                // 1. 줄 서 있는 학생 중에 자신보다 큰 학생을 찾는다.
                // 1-1. 찾지 못했다면, 줄의 가장 뒤에 선다.
                boolean find = false;
                // 2. 찾았다면, 그 학상의 앞에 선다.
                // 3. 그 학생과 그 뒤의 학생이 한칸씩 물러난다.


                for (int j=0; j<i; j++){
                    if (sorted[j] > h[i]){
                        // 2. 찾았다면, 그 학생의 앞에 선다.
                        // 3. 그 학생과 그 뒤의 학생이 모두 한칸씩 물러난다.
                        find = true;
                        for (int k=i-1; k>=j; k--){
                            sorted[k+1] = sorted[k];
                            cnt++;
                        }
                        sorted[j] = h[i];
                        break;
                    }
                }
                if (!find) sorted[i] = h[i];
            }
            
            System.out.println(T + " " + cnt);


        }



    }
    
    
}
