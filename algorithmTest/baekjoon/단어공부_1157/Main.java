package baekjoon.단어공부_1157;

/**
 * 1. 아이디어
 * 26개의 배열에 하나씩 집어넣어서 갯수를 센다.
 * 2. 시간복잡도
 * - O(N) => 1000000 > 가능!
 * 3. 자료구조
 * - int[] 알파벳만큼 
 */


import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int arr[] = new int[26];

        String alpabat = input.nextLine();

        for (int i=0; i<alpabat.length(); i++){
            char temp = alpabat.charAt(i);
            if (temp >= 'a' && temp <= 'z')
                arr[alpabat.charAt(i) - 'a']++;
            else if (temp >= 'A' && temp <= 'Z')
                arr[alpabat.charAt(i) - 'A']++;
        }   


        int max = -1;
        char ch = '?';

        for (int i=0; i<26; i++){
            if (arr[i] > max){
                max = arr[i];
                ch = (char) (i + 'A');
            }else if (arr[i] == max){
                ch = '?';
            }
        }

        System.out.print(ch);
    }
    
}
