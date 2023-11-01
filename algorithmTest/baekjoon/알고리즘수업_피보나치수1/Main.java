package baekjoon.알고리즘수업_피보나치수1;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        System.out.print(fib(n) + " ");
        System.out.print(fibonacci(n));
    }


    public static int fib(int n){
        if (n == 1 || n == 2)
            return 1;
        
        return (fib(n - 1) + fib(n - 2));
    }

    public static int fibonacci(int n){
        int f[] = new int[n];
        f[0] = f[1] = 1;

        int cnt = 0;
        for (int i=2; i<n; i++){
            cnt ++;
            f[i] = f[i-1] + f[i-2];
        }

        return cnt;

    }

    
}
