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