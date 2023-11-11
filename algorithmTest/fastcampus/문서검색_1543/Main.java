package fastcampus.문서검색_1543;

import java.util.*;


class MyTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String doc = input.nextLine();
        String findWord = input.nextLine();
        int fwLeng = findWord.length();
        int cnt = 0;

        while(doc.contains(findWord)){
            int index = doc.indexOf(findWord);
            doc = doc.substring(fwLeng + index, doc.length());
            cnt ++;
        }

        System.out.println(cnt);

    }
    
}


public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String doc = input.nextLine();
        String word = input.nextLine();
        
        // int cnt = 0;
        // int startIndex = 0;

        // while(true){
        //     int findIndex = doc.indexOf(word, startIndex);
        //     if (findIndex < 0)
        //         break;

        //     cnt ++;
        //     startIndex = findIndex + word.length();
        // }
        // System.out.println(cnt);

        
        String replaced = doc.replace(word, "");
        int length = doc.length() - replaced.length();
        int count = length / word.length();

        System.out.println(count);
    }
}
