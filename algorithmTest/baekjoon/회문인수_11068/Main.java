package baekjoon.회문인수_11068;

import java.util.Scanner;

public class Main{

    public static int converBase(int digit, int base, int[] reverseDigit){
        int len = 0;

        while (digit > 0){
            reverseDigit[len++] = digit % base;
            digit /= base;
        }
        return len;
    }

    public static boolean isPalindrome(int[] digit, int length){
        for (int i=0; i<length / 2; i++){
            if (digit[i] != digit[length -i -1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i=0; i<testCase; i++){
            int digit = sc.nextInt();


            boolean anser = false;
            for (int j=2; j<65; j++){
                int baseDigit[] = new int[20];
                int length = converBase(digit, j, baseDigit);
                if (isPalindrome(baseDigit, length)){
                    anser = true;
                    break;
                }
            }
            System.out.println(anser ? "1" : "0");

        }

    }

}