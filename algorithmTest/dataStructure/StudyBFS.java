package dataStructure;

import java.util.*;

// 최단거리 구하는 알고리즘

public class StudyBFS {
    public static void main(String[] args){
        int [][] matrix = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
        boolean[] visited = new boolean[9];
        int startNodeIndex = 1;

        System.out.println(bfs(startNodeIndex, matrix, visited));
    }

    public static String bfs(int start, int[][] matrix, boolean[] visited){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);

        visited[start] = true;

        while (!queue.isEmpty()){
            int nodeIndex = queue.poll();
            sb.append(nodeIndex + " -> ");

            for (int i=0; i<matrix[nodeIndex].length; i++){
                int temp = matrix[nodeIndex][i];

                if (!visited[temp]){
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }

        return sb.toString();
    }

}
