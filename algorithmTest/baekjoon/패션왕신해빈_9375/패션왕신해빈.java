package baekjoon.패션왕신해빈_9375;

import java.util.*;

public class 패션왕신해빈 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i=0; i<testCase; i++){
            int cnt = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();

            for(int j=0; j<cnt; j++){
                String name = sc.next(), type = sc.next();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }


            int result = 1;
            for (int value : map.values())
                result *= value + 1;

            System.out.println(result -1);
        }


    }
}
