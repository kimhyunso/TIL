package baekjoon.ACM호텔_10250;

import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCase = input.nextInt();

        while (testCase-- > 0){
            // 층수 (높이)
            int H = Integer.parseInt(input.next());
            // 가로
            int W = Integer.parseInt(input.next());
            // 몇 번째 손님인지
            int N = Integer.parseInt(input.next());

            int floor = (N-1) % H + 1;;
            int distance = (N-1) / H + 1;

            System.out.printf("%d%02d\n", floor, distance);
        }


    }
}