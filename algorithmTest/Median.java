import java.util.Scanner;

public class Median{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("a 값 입력 : ");
        int a = sc.nextInt();
        System.out.print("b 값 입력 : ");
        int b = sc.nextInt();
        System.out.print("c값 입력 : ");
        int c = sc.nextInt();

        int median = median(a, b, c);
        System.out.println("세개의 값 중 중앙값 : " + median);

    }

    public static int median(int a, int b, int c){
        if (a >= b){


        }else if (a <= c){
            
        }

        return 0;
    }





}