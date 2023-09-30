import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("a값 입력 : ");
        int a = sc.nextInt();
        System.out.print("b 값 입력 : ");
        int b = sc.nextInt();
        System.out.print("c 값 입력 : ");
        int c = sc.nextInt();

        int max = a;
        if (max < b)
            max = b;
        else if (max < c)
            max = c;

        System.out.println("최대값 : "+ max);
    }
    
}
