package baekjoon.약수구하기_2501;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int count = 0;
        int result = 0;

        for (int i=1; i<=N; i++){
            if (N % i == 0){
                count ++;
            }

            if (count == K){
                result = i;
                break;
            }
        }

        System.out.println(result);



    }
    
}
