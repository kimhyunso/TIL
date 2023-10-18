package baekjoon.DFS와BFS_1260;

import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int nodeCount = input.nextInt();
        int vertexCount = input.nextInt();
        int startNodeIndex = input.nextInt();

        int[][] matrix = new int[nodeCount + 1][nodeCount + 1];
        boolean visited[] = new boolean[nodeCount + 1];

        while (vertexCount-- != 0){
            int x = input.nextInt();
            int y = input.nextInt();
            matrix[x][y] = y;
        }
        dfs(startNodeIndex, visited, matrix);
    }


    public static void dfs(int index, boolean visited[], int matrix[][]){
        visited[index] = true;

        System.out.print(index + " ");

        for (int node : matrix[index]){
            if (visited[node] != true && node != 0){
                dfs(node, visited, matrix);
            }

        }
    }
}
