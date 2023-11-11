package fastcampus.애너그램만들기_1919;

import java.io.*;

/**
 * 1. 아이디어
 * - 두번째 줄 string에 대해 for문을 돌면서 같은 문자열의 갯수를 센다.
 * 2. 시간복잡도
 * - O(N) -> 1000 > 가능
 * 3. 자료구조
 * - 첫번째 영단어 String
 * - 두번째 영단어 String
 */


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String A = input.readLine();
        String B = input.readLine();
        /*
                                    //        a, b, c, d, e ...
        int countA[] = new int[26]; // dared [1, 0, 0, 2, 1 ...]
        int countB[] = new int[26];

        for (int i=0; i<A.length(); i++){
            countA[A.charAt(i) - 'a'] ++;
        }

        for (int i=0; i<B.length(); i++){
            countB[B.charAt(i) - 'a']++;
        }*/

        int countA[] = getAlphabetCount(A);
        int countB[] = getAlphabetCount(B);


        int cnt = 0;
        for (int i=0; i<countA.length; i++){
            
            cnt += Math.abs(countA[i] - countB[i]); 
            /* if (countA[i] > countB[i]){
                cnt += countA[i] - countB[i];
            }else if (countB[i] > countA[i]){
                cnt += countB[i] - countA[i];
            }*/
        }


        System.out.println(cnt);
    }

    public static int[] getAlphabetCount(String str){
        int[] count = new int[26];

         for (int i=0; i<str.length(); i++){
            count[str.charAt(i) - 'a'] ++;
        }

        return count;
    }
    
}
