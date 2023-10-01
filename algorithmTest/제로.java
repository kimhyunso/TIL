import java.util.Scanner;
import java.util.Stack;

public class 제로 {
    
    public static void main(String[] args){
        Stack<Integer> moneyList = new Stack<Integer>(); 
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int sum = 0;

        for (int i=0; i<count; i++){
            int money = sc.nextInt();
            if (money == 0)
                moneyList.pop();
            else
                moneyList.push(money);
        }

        if (moneyList.isEmpty())
            System.out.print(0);
        else{
            for (int i=0; i<moneyList.size(); i++){
                sum += moneyList.get(i);
            }
            System.out.print(sum);
        }

    }

}
