package baekjoon.균형잡힌세상_4949;

import java.util.*;
import java.io.*;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        
        String s;

        while (true){
             
            s = in.nextLine();
            if (s.equals("."))
                break;

            System.out.println(solv(s));
               
        }
    }   

    public static String solv(String s){
        Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// 여는 괄호일 경우 스택에 push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}else if(c == ')') {
				
				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}else if(c == ']') {
				
				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
            
    }
}
