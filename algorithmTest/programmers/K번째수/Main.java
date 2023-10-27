package programmers.K번째수;

import java.util.*;

public class Main {
    public static void main(String[] args){
        // int[] array = {};
        // solution(array,);

        
    }

    public static int[] solution(int[] array, int[][] commands){
        int answer[] = new int[commands.length];
        for (int i=0; i<commands.length; i++){
            int to = commands[i][0];
            int from = commands[i][1];
            int findIndex = commands[i][2];

            array = Arrays.copyOfRange(array, to, from);
            Arrays.sort(array);

            answer[i] = array[findIndex-1];
        }



        return answer;
    }
}
