package baekjoon.그림_1926;

/**
 * 1. 아이디어
 * - 2중 for => 값 1 && 방문X => BFS
 * - BFS 돌면수 그림 개수 +1, 최대값을 갱신
 * 
 * 2. 시간복잡도
 * - BFS : O(V+E) 최대 M:500, N:500
 * - V : M * N => 500 * 500
 * - E : V * 4 => 4 * 500 * 500
 * - V+E : 5 * 25000 = 100만 < 2억 >> 가능!
 * 
 * 3. 자료구조
 * - 그래프 전체 지도 : int[][]
 * - 방문 : bool[][]
 * - Queue(BFS)
 */

import java.util.*;
import java.io.*;

public class Main{


    // 상하좌우
    static int mx[] = {0, 0, -1, 1};
    static int my[] = {-1, 1, 0, 0};
    static int[][] graph;
    static boolean[][] visited;
    static int width;
    static int height;

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");
        
       
        height = Integer.parseInt(token.nextToken());
        width = Integer.parseInt(token.nextToken());

        graph = new int[height][width];
        visited = new boolean[height][width];
     

        for (int i=0; i<height; i++){
            token = new StringTokenizer(input.readLine(), " ");
            for (int j=0; j<width; j++){
                graph[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int paintCnt = 0;
        int maxCnt = 0;
        for (int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if (!visited[i][j] && graph[i][j] == 1){
                    visited[i][j] = true;
                    maxCnt = Math.max(bfs(j, i), maxCnt);
                    paintCnt ++;
                }
                
            }
        }

      
        System.out.println(paintCnt);
        System.out.println(maxCnt);
    }


    public static int bfs(int x, int y){
        int maxCnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()){
            int xAndy[] = queue.poll();
            int currentX = xAndy[0];
            int currentY = xAndy[1];
               

            for (int i=0; i<4; i++){
                int moveX = currentX + mx[i];
                int moveY = currentY + my[i];

                if (moveX >= 0 && moveY >= 0 && moveX < width && moveY < height){
                    if (!visited[moveY][moveX] && graph[moveY][moveX] == 1){
                        visited[moveY][moveX] = true;
                        queue.offer(new int[]{moveX, moveY});
                        maxCnt ++;
                    } 
                }
            }
        }

        return maxCnt;

    }
}