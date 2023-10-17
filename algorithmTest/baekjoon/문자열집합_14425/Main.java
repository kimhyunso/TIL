package baekjoon.문자열집합_14425;

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        input.nextLine();
        Map<String, Integer> map = new HashMap<>();
  
        for(int i=0; i<N; i++){
            map.put(input.nextLine(), 0);
        }

        int count = 0;
        for (int i=0; i<M; i++){
            if(map.containsKey(input.nextLine())) count ++;
        }

        System.out.println(count);
    }
}
