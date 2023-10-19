package baekjoon.단지번호붙이기_2267;

import java.util.*;


public class Main {

    public static boolean[][] visited;
    public static int[][] graph;
    // 상하좌우
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};


    public static int count;
    public static int totalCnt;
    public static ArrayList<Integer> list;
    public static int N;


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        input.nextLine();

        visited = new boolean[N][N];
        graph = new int[N][N];
        list = new ArrayList<Integer>();
        totalCnt = 0;
        count = 0;

        for (int i=0; i<N; i++){
            String line = input.nextLine();
            for (int j=0; j<N; j++){
                graph [i][j] = line.charAt(j) - '0';
            }
        }

        for (int i=N-1; i>=0; i--){
            for (int j=N-1; j>=0; j--){
                totalCnt = 0;
                if (!visited[i][j] && graph[i][j] == 1){
                    dfs(i, j);
                    count ++;
                }
                list.add(totalCnt);
            }
        }

        System.out.println(count);



        Collections.sort(list);
        for (int total : list){
            if (total != 0)
                System.out.println(total);
        }

       
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        totalCnt ++;
        
        for (int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < N && cy < N){
                if (!visited[cx][cy] && graph[cx][cy] == 1){
                    dfs(cx, cy);
                }
            }
        }
    }

}
