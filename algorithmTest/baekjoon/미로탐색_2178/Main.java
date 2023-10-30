package baekjoon.미로탐색_2178;

import java.util.*;
import java.io.*;

public class Main {
    // 상하좌우
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {1, -1, 0, 0};

    static boolean[][] visited;
    static int [][] graph;

    static int width;
    static int height;

    public static void main(String[] args) throws IOException{
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");
        width = Integer.parseInt(token.nextToken());
        height = Integer.parseInt(token.nextToken());

        visited = new boolean[width][height];
        graph = new int[width][height];
    

        for (int i=0; i<width; i++){
            String map = input.readLine();
            for (int j=0; j<height; j++){
                graph[i][j] = map.charAt(j) - '0';
            }
        }

      
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(graph[width-1][height-1]);

    }


    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()){
            int position[] = q.poll();
            int nx = position[0];
            int ny = position[1];

            for (int i=0; i<4; i++){
                int cx = nx + mx[i];
                int cy = ny + my[i];


                if (cx >= 0 && cy >= 0 && cx < width && cy < height){
                    if (!visited[cx][cy] && graph[cx][cy] == 1){
                        q.add(new int[]{cx, cy});
                        graph[cx][cy] = graph[nx][ny] + 1;
                        visited[cx][cy] = true;
                    }
                }

               
            }

        }

    }


}
