package baekjoon.균형잡힌세상_4949;


/*
세계는 균형이 잘 잡혀있어야 한다. 양과 음, 빛과 어둠 그리고 왼쪽 괄호와 오른쪽 괄호처럼 말이다.

정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.

문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.

모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.
 */

/*
풀이법 : 
( 이거나 [ 이면 스택에 push
1. ) 일때 : 
1-1 스택이 비어있거나 pop할 원소가 (랑 매칭이 안되는 경우 :  return "no" 
1-2 스택이 비어있지 않고, (랑 매칭되는 경우 : 스텍에 pop()
2. ] 일때 : 
2-1 스택이 비어있거나 pop할 원소가 [랑 매칭이 안되는 경우 :  return "no" 
2-2 스택이 비어있지 않고, [랑 매칭되는 경우 : 스텍에 pop() 
 */


import java.util.*;
import java.io.*;

class Main {
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
