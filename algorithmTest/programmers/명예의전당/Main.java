package programmers.명예의전당;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        solution(k, score);



    }


    public static int[] solution(int k, int[] score){
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<score.length; i++){
            if (pq.size() >= k){
                if (pq.peek() < score[i]){
                    pq.poll();
                    pq.offer(score[i]);
                }

            }else{
                pq.offer(score[i]);
            }
            
            answer[i] = pq.peek();

        }

        return answer;
    }


}
