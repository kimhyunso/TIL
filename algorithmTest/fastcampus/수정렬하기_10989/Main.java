package fastcampus.수정렬하기_10989;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(input.readLine());
        int[] cnt = new int[10001];
        for(int i=0; i<N; i++){
            cnt[Integer.parseInt(input.readLine())]++;
        }

        for (int i=1; i<=10000; i++){
            while(cnt[i]-- > 0){
                out.write(i + "\n");
            }
        }
        out.flush();


        
        // Scanner input = new Scanner(System.in);

        // int N = input.nextInt();
        // int[] cnt = new int[10001];

        // for (int i=0; i<N; i++){
        //     cnt[input.nextInt()]++;
        // }

        // for (int i=1; i<=10000; i++){
        //     while(cnt[i]-- > 0){
        //         System.out.println(i);
        //     }
        // }


    }
    
}
