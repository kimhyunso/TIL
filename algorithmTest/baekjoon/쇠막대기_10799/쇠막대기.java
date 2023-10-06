

import java.util.*;
import java.io.*;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<Character>();
        String stick = br.readLine();
        int count = 0;

        for (int i=0; i<stick.length(); i++){
            char value = stick.charAt(i);
            if (value == '(')
                stack.push(value);
            else{
                stack.pop();
                if (stick.charAt(i-1) == '(')
                    count += stack.size();
                else
                    count ++;
            }
        }
        System.out.println(count);
    }
}
