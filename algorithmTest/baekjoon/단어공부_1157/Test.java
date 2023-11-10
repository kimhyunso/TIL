package baekjoon.단어공부_1157;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();

        int count[] = alpabatCount(str);

        char answer = '?';

        for (int i=0; i<count.length; i++){
            

        }

        System.out.println(answer);
    }

    public static int[] alpabatCount(String str){
        int[] count = new int[26];

        for (int i=0; i<str.length(); i++){
            count[str.charAt(i) - 'a'] ++;
        }
        return count;

    }
}
