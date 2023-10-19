package baekjoon.DFS와BFS_1260;

import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int nodeCount = input.nextInt();
        int edgeCount = input.nextInt();
        int startNodeIndex = input.nextInt();

        int[][] matrix = new int[nodeCount + 1][nodeCount + 1];
        boolean visited[] = new boolean[nodeCount + 1];

        while (edgeCount-- != 0){
            int x = input.nextInt();
            int y = input.nextInt();
            matrix[x][y] = y;
            matrix[y][x] = x;
        }

        dfs(startNodeIndex, visited, matrix);
        System.out.println();

        visited = new boolean[nodeCount + 1];
        bfs(startNodeIndex, visited, matrix);
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


    public static void bfs(int index, boolean visited[], int matrix[][]){
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(index);
        visited[index] = true;

        while(!queue.isEmpty()){
            int nodeIndex = queue.poll();
            System.out.print(nodeIndex + " ");

            for (int i=0; i<matrix[nodeIndex].length; i++){
                int temp = matrix[nodeIndex][i];

                if (!visited[temp] && temp != 0){
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }



    }
}
