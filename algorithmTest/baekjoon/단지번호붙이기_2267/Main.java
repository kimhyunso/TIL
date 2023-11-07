package baekjoon.단지번호붙이기_2267;

import java.util.*;

/**
 * 1. 아이디어
 * - 2중 for, 값 1 && 방문 X ==> DFS
 * - DFS를 통해 찾은 값을 저장 후 정렬해서 출력
 * 2. 시간복잡도
 * - DFS : O(V+E)
 * - V, E : N^2, 4M^2
 * - V+E : 5N^2 ~= N^2 ~= 625 >> 가능
 * 3. 자료구조
 * - 그래프 저장 : int[][]
 * - 방문여부 : bool[][]
 * - 결과값 저장 리스트
 */



public class Main {

    public static boolean[][] visited;
    public static int[][] graph;
    // 상하좌우
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static int aptCount;
    public static int totalCnt;
    public static ArrayList<Integer> housCntList;
    public static int N;


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        input.nextLine();

        visited = new boolean[N][N];
        graph = new int[N][N];
        housCntList = new ArrayList<Integer>();
        

        for (int i=0; i<N; i++){
            String line = input.nextLine();
            for (int j=0; j<N; j++){
                graph [i][j] = line.charAt(j) - '0';
            }
        }


        // 단지수 카운트
        aptCount = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                totalCnt = 0;
                if (!visited[i][j] && graph[i][j] == 1){
                    dfs(i, j);
                    aptCount ++;
                }
                housCntList.add(totalCnt);
            }
        }

        System.out.println(aptCount);

        Collections.sort(housCntList);
        for (int total : housCntList){
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
