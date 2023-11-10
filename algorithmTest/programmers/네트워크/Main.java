
/**
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 */
/**
 * 풀이법 : dfs를 사용 (스택, 재귀함수를 이용한 알고리즘)
 * 서로간의 간선을 확인하며 방문을 표시,
 * 방문하지 않았고, 간선이 이어져있다면(1이라면) bfs를 돌고
 * 간선이 이어져있지 않다면 다른 네트워크로 간주 할 수 있으므로, answer값을 증가
 * 
 */

class Solution {
    
    public static void main(String[] args){
        int n = 3;
        int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers));
    }
    
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        
        for(int i=0; i<n; i++){
            if (!visited[i]){
                dfs(i, computers, visited);
                answer ++;
            }
               
        }
       
        
        return answer;
    }
    
    public static void dfs(int nodeIndex, int[][] computers, boolean visited[]){
        visited[nodeIndex] = true;
        
        for (int i=0; i<computers[nodeIndex].length; i++){
            
            if (!visited[i] && computers[nodeIndex][i] == 1) 
                dfs(i, computers, visited);
               
        }
        
    }
}