package dataStructure;
import java.util.*;

public class StudyDFSStack {
    static boolean[] visited = new boolean[9];
    static int[][] matrix = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args){
        // 시작 노드를 스택에 넣는다.
        stack.push(1);

        visited[1] = true;

        while (!stack.empty()){
            // 1. 1 pop
            // 2. 8 pop
            // 3. 3 pop
            // 4. 5 pop
            // 5. 7 pop
            // 6. 4 pop
            // 7. 2 pop
            // 8. 6 pop
            int nodeIndex = stack.pop();
            System.out.println(nodeIndex + " -> ");
            // 1. 2, 3, 8 push
            // 2. 1, 2 push
            // 3. 5 push
            // 4. 4, 7 push
            // 8 6 push
            for(int LinkedNode : matrix[nodeIndex]){
                if (!visited[LinkedNode]){
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }
    }
    
}
