/*
 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 
 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 */


import java.util.*;
import java.io.*;

class 숫자카드2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cardN[] = new int[N];
        int cnt = 0;

        while (st.hasMoreTokens()){
            cardN[cnt++] = Integer.parseInt(st.nextToken());
        }

      
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int cardM[] = new int[M];
        cnt = 0;

        while (st.hasMoreTokens()){
            cardM[cnt++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardN);



        for (int i=0; i<cardM.length; i++){
            int lowerBound = lowerBound(cardM[i], cardN);
            int upperBound = upperBound(cardM[i], cardN);
            sb.append((upperBound - lowerBound) + " ");
        }

        System.out.print(sb.toString());
    }


    public static int lowerBound(int key, int arr[]){
        int left = 0;
        int right = arr.length;
        int mid = 0;

        while(left < right){
            mid = (left + right) / 2;
            
            if (key <= arr[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public static int upperBound(int key, int arr[]){
        int left = 0;
        int right = arr.length;
        int mid = 0;

        while (left < right){
            mid = (left + right) / 2;

            if (key < arr[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

}