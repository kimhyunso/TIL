package baekjoon.팰린드롬인지확인하기;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        char newText[] = new char[name.length()];

        for (int i=0; i<name.length(); i++){
            char left = name.charAt(i);
            char right = name.charAt((name.length()-1) - i);
            newText[i] = right;
            newText[(name.length()-1) - i] = left;
        }

        String newStr = "";
        for (int i=0; i<newText.length; i++){
            newStr += String.valueOf(newText[i]);
        }

        if (name.equals(newStr))
            System.out.println(1);
        else
            System.out.println(0);
        
    }
}
