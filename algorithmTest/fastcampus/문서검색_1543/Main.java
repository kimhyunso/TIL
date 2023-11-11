package fastcampus.문서검색_1543;

import java.util.*;


public class Main {
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
