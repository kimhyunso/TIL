package fastcampus.빠른_A_B_15552;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // Scanner input = new Scanner(System.in);
        // int T = input.nextInt();

        // for (int i=0; i<T; i++){
        //     int A = input.nextInt();
        //     int B = input.nextInt();

        //     System.out.println(A+B);
        // }
        solution();
    }

    public static void solution() throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(input.readLine());
        for (int i=0; i<T; i++){
            String[] numbers = input.readLine().split(" ");

            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);

            out.write(A+B + "\n");
        }
        out.flush();
    }
    
}
