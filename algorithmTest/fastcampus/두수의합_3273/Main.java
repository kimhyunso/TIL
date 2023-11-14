package fastcampus.두수의합_3273;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");

        int arr[] = new int[n];


        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int findNum = Integer.parseInt(input.readLine());


        // int left = 0;
        // int right = arr.length - 1;
        // Arrays.sort(arr);
        // int cnt = 0;

        // while (left < right){

        //     if (arr[left]+arr[right] == findNum){
        //         left++;
        //         right--;
        //         cnt ++;
        //     }else if (arr[left]+arr[right] > findNum){
        //         right--;
        //     }else{
        //         left++;
        //     }

        // }

        // System.out.println(cnt);


        boolean[] exist = new boolean[1000001];

        for (int i=0; i<n; i++){
            exist[arr[i]] = true;
        }

        int ans = 0;
        for (int i=0; i<n; i++){
            int pairValue = findNum - arr[i];
            if (0 <= pairValue && pairValue <= 1000000){
                ans += exist[pairValue] ? 1 : 0;
            }
        }
        System.out.println(ans/2);





    }
    
}
