package programmers.K번째수;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };
        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands){
        int answer[] = new int[commands.length];
        
        for (int i=0; i<commands.length; i++){
            int temp[];
            int to = commands[i][0];
            int from = commands[i][1];
            int findIndex = commands[i][2];

            temp = Arrays.copyOfRange(array, to-1, from);
            Arrays.sort(temp);

            answer[i] = temp[findIndex-1];
        }



        return answer;
    }
}
