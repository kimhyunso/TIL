package programmers.바탕화면정리;

public class Main {
    public static void main(String[] args){
        String wallpaper[] = {".#...", "..#..", "...#."};

        int [] arr = solution(wallpaper);
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }


    public static int[] solution(String[] wallpaper){
        int minRow, minCol;
        int maxRow, maxCol;
        
        // 21억
        minRow = minCol = Integer.MAX_VALUE;
        // -21억
        maxRow = maxCol = Integer.MIN_VALUE;

        int row = wallpaper.length;
        int col = wallpaper[0].length();

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return new int[]{minRow, minCol, maxRow+1, maxCol+1};
    }
}
