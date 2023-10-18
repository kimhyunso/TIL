package baekjoon.바이러스_2606;

import java.util.*;


public class Main {
    static int count = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int comuterCount = input.nextInt();
        int edgeCount = input.nextInt();
        int graph[][] = new int[comuterCount + 1][comuterCount + 1];
        boolean visited[] = new boolean[comuterCount + 1];
        Stack<Integer> stack = new Stack<Integer>();

        while(edgeCount-- != 0){
            int x = input.nextInt();
            int y = input.nextInt();
            graph[x][y] = y;
            graph[y][x] = x;
        }
        int startNodeIndex = 1;
        stack.push(startNodeIndex);
        visited[startNodeIndex] = true;

        // bfs(startNodeIndex, visited, graph);
        
        stackBfs(stack, graph, visited);
        System.out.println(count);


    }

    public static void stackBfs(Stack<Integer> stack, int graph[][], boolean[] visited){
        while(!stack.isEmpty()){
            int nodeIndex = stack.pop();

            for (int index : graph[nodeIndex]){    
                if(!visited[index] && index != 0){
                    visited[index] = true;
                    stack.push(index);
                    count ++;
                }
            }

        }
    }


    public static void bfs(int nodeIndex, boolean[] visited, int graph[][]){
        visited[nodeIndex] = true;

        for (int index : graph[nodeIndex]){
            if (!visited[index] && index != 0){
                bfs(index, visited, graph);
                count ++;
            }
        }
        
    }

}
