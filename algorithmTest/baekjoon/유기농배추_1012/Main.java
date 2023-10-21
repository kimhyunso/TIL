package baekjoon.유기농배추_1012;

import java.util.*;
import java.io.*;

public class Main {
    public static int width, height, cabbageCount;
    public static int cabbage[][];
    public static boolean visited[][];
    public static int dx[] = {0, 0, -1, 1};
    public static int dy[] = {-1, 1, 0, 0};
    public static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        
        for (int i=0; i<testCase; i++){
            count = 0;
            StringTokenizer token = new StringTokenizer(input.readLine(), " ");
            width = Integer.parseInt(token.nextToken());
            height = Integer.parseInt(token.nextToken());
            cabbage = new int[width][height];
            visited = new boolean[width][height];

            cabbageCount = Integer.parseInt(token.nextToken());

            for(int j=0; j<cabbageCount; j++){
                token = new StringTokenizer(input.readLine(), " ");
                int posX = Integer.parseInt(token.nextToken());
                int posY = Integer.parseInt(token.nextToken());
                cabbage[posX][posY] = 1;
            }


            for (int x=0; x<width; x++){
                for (int y=0; y<height; y++){
                    // 배추가 존재하고, 방문을 하지 않았는가?
                    if (cabbage[x][y] == 1 && !visited[x][y]){
                        stackBfs(x, y);
                        // 벌레 갯수 증가
                        count ++;
                    }

                }
            }

            System.out.println(count);
        }
    }


    public static void stackBfs(int x, int y){
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()){
            x = stack.peek()[0];
            y = stack.peek()[1];
            visited[x][y] = true;
            stack.pop();

            for (int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                // cx, cy 0 이상이고 cx, cy width/height 미만
                if (cx >= 0 && cy >= 0 && cx < width && cy < height){
                    if(!visited[cx][cy] && cabbage[cx][cy] == 1){
                        stack.push(new int[]{cx, cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }



    public static void dfs(int x, int y){
        // 방문처리
        visited[x][y] = true;

        // 상하좌우 검색
        for (int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            // cx, cy가 0 이하, 농장의 가로, 세로크기 보다 작아야함
            // -1 같은 경우 visited, cabbage에 포함되는 경우가 없음 0~N
            // 벽을 검사하는 것
            if (cx >= 0 && cy >= 0 && cx < width && cy < height){

                // 배추의 여부 및 방문을 하지 않았는가?
                if(!visited[cx][cy] && cabbage[cx][cy] == 1){
                    dfs(cx, cy);
                }
            }
        }
    }


    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});        

        while (!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.peek()[1];
            visited[x][y] = true;
            queue.poll();

            for (int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < width && cy < height){
                    if (!visited[cx][cy] && cabbage[cx][cy] == 1){
                        queue.offer(new int[]{cx, cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }
    
}
