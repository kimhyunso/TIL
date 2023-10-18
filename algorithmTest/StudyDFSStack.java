import java.util.*;

public class StudyDFSStack {
    static boolean[] visited = new boolean[9];
    static int[][] matrix = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args){
        // 시작 노드를 스택에 넣는다.
        stack.push(1);

        visited[1] = true;

        while (!stack.isEmpty()){
            int nodeIndex = stack.pop();
            System.out.println(nodeIndex + " -> ");

            for(int LinkedNode : matrix[nodeIndex]){

                if (!visited[LinkedNode]){
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }
    }
    
}
