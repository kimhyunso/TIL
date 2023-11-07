package baekjoon.N과M_15649;
/**
 * 중복없이 고르기
 * 1. 아이디어
 * - 백트래킹 재귀함수 안에서 for 돌면서 숫자 선택(이때 방문여부 확인)
 * - 재귀함수에서 M개를 선택할 경우 print 
 * 2. 시간복잡도
 * - N! > 가능!
 * 3. 자료구조
 * - 결과값 저장 int[]
 * - 방문여부 체크 bool[]
 * 
 */

import java.util.*;
import java.io.*;

class MainT {

    static int result[];
    static boolean visited[];
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        result = new int[N+1];
        visited = new boolean[N+1];
        recuriveCall(0);
    }

    // 0
    public static void recuriveCall(int num){
        if (num == M){

            for (int i=0; i<M; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        // 1 ~ 3 
        for (int i=1; i<=N; i++){
            if (!visited[i]){
                visited[i] = true;
                result[num] = i;
                recuriveCall(num+1);
                visited[i] = false;
            }
        }

    }
}
