package programmers.추억점수;

import java.util.*;

public class Main {
    public static void main(String[] args){

        String name[] = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}
        };

        solution(name, yearning, photo);
    }


    public static int[] solution(String[] name, int[] yearning, String[][] photo){
        HashMap<String, Integer> frends = new HashMap<String, Integer>();
        int[] answer = new int[photo.length];
        
        for (int i=0; i<name.length; i++){
            frends.put(name[i], yearning[i]);
        }
        
        for (int i=0; i<photo.length; i++){
            int cnt = 0;
            for(int j=0; j<photo[i].length; j++){
                if (frends.containsKey(photo[i][j])){
                    cnt += frends.get(photo[i][j]);
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
