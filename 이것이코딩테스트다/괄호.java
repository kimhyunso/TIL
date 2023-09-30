import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Character> stack = new Stack<Character>();
		sc.nextLine();

		for (int i=0; i<T; i++){
			String bracket = sc.nextLine();
			
			for (int j=0; j<bracket.length(); j++){
				stack.push((char)(bracket.charAt(j)));	
			}
		}

	}
}


