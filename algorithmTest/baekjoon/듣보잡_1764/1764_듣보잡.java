/*
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 
듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.  
 */

 /*
풀이법 : 
듣도 못한 사람의 명단을 중복되지 않는 HashSet에 데이터를 집어넣고,
보도 못한 사람의 명단과 비교하여 맞으면 (contains) ArrayList에 삽입
출력시, A인 데이터부터 출력하기위해 sort후 ArrayList.size와 ArrayList item을 출력
  */

import java.util.*;
import java.io.*;

class 듣보잡 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

     
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if(set.contains(tmp)){
                result.add(tmp);
            }
        }

        // a부터 나오게 하기 위해서 sort를 함
        Collections.sort(result);

        // print result
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    
    }   
    
}
