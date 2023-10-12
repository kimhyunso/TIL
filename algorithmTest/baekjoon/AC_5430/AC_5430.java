package baekjoon.AC_5430;

import java.util.*;
import java.io.*;



public class AC_5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0; i<testCase; i++){
            String command = input.readLine();
            int size = Integer.parseInt(input.readLine());
            int arr[] = new int[size];
            String arrNumber = input.readLine();
            String test[] = arrNumber.split(",");

            
            Arrays.sort(arr);

            
        }
    }

    public static int[] opration(int[] arr, String command){

        if (command.equals("R")){

        }else{

        }
        return null;
    }
    
}
