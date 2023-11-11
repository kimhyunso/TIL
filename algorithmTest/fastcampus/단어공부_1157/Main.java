package fastcampus.단어공부_1157;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // String str = input.readLine();
        String str = input.readLine().toUpperCase();

        // int count[] = alpabatCount(str);



        int maxCount = -1;
        char maxAlphabet = '?';
        // I: 4, M: 1, P: 1, S: 4

        // for (int i=0; i<count.length; i++){
           

        //     if (count[i] > maxCount){
        //         maxCount = count[i];
        //         maxAlphabet = (char)('A' + i);
        //     }else if (count[i] == maxCount){
        //         maxAlphabet = '?';
        //     }
        
        // }



        for (char apl='A'; apl<='Z'; apl++){
            int count = alpabatCount(str, apl);

            if (count > maxCount){
                maxCount = count;
                maxAlphabet = apl;
            }else if (count == maxCount){
                maxAlphabet = '?';
            }
        
        }


        System.out.println(maxAlphabet);
    }

    public static int[] alpabatCount(String str){
        int[] count = new int[26];

        for (int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            // 대문자
            // if (temp >= 'A' && temp <= 'Z'){
            //     count[str.charAt(i) - 'A'] ++;
            // }else if (temp >= 'a' && temp <= 'z'){
            //     count[str.charAt(i) - 'a']++;
            // }

            count[str.charAt(i) - 'A']++;

        }

        return count;
    }


    public static int alpabatCount(String str, char alp){
        int count = 0;

        for (int i=0; i<str.length(); i++){
            if (alp == str.charAt(i)) count ++;
        }

        return count;
    }


}
