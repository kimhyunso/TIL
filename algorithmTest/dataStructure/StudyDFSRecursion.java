package dataStructure;
public class StudyDFSRecursion {

    static boolean[] visitied = new boolean[9];
    static int[][] matrix = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};


    public static void main(String[] args){
        int startIndex = 1;
        dfs(startIndex);
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void dfs(int nodeIndex){
        visitied[nodeIndex] = true;

        System.out.println(nodeIndex + " -> ");

        for (int node : matrix[nodeIndex]){
            if (!visitied[node]){
                dfs(node);
            }
        }
    }
    
}
