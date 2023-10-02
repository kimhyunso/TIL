import java.util.*;

public class 스택수열 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();


        int count = sc.nextInt();
        int start = 0;

        for (int i=0; i<count; i++){    
            int value = sc.nextInt();


            if(value > start) {
				for(int j = start + 1; j <= value; j++) {
					stack.push(j);
                    sb.append("+").append("\n");
					
				}
				start = value; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화 
			}else if (stack.peek() != value){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
            
        }
        System.out.println(sb);


    }

}
