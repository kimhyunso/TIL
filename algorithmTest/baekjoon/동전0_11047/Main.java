package baekjoon.동전0_11047;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");
        ArrayList<Integer> coinList = new ArrayList<Integer>();

        int coinKind = Integer.parseInt(token.nextToken());
        int moneyTotal = Integer.parseInt(token.nextToken());
        int result = 0;

        for(int i=0; i<coinKind; i++){
            coinList.add(Integer.parseInt(input.readLine()));
        }

        for (int i=coinList.size()-1; i>=0; i--){
            result += moneyTotal / coinList.get(i);
            moneyTotal = moneyTotal % coinList.get(i);
        }

        System.out.println(result);
    }
}
