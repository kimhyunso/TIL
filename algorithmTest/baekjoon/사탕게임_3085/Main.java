package baekjoon.사탕게임_3085;

/**
 * 상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
 * 가장 처음에 N×N크기에 사탕을 채워 놓는다. 
 * 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 
 * 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 
 * 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
 * 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
 */



import java.util.*;

public class Main {

    public static int findMaxRow(char[][] candies){
        int maxRow = 0;

        for (int i=0; i<candies.length; i++){
            int len = 1;
            for (int j=1; j<candies[0].length; j++){
                if(candies[i][j] == candies[i][j-1]) len ++;
                else{
                    maxRow = Math.max(maxRow, len);
                }
                
            }
            maxRow = Math.max(maxRow, len);
        }

        return maxRow;
    }

    public static int findMaxColumn(char [][]candies){
        int maxColumn = 0;

        for (int i=0; i<candies.length; i++){
            int len = 1;
            for (int j=1; j<candies[0].length; j++){
                if(candies[i][j] == candies[i][j-1]) len ++;
                else{
                    maxColumn = Math.max(maxColumn, len);
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
     
        return maxColumn;
    }

    public static void candySwap(char [][]candies, int x1, int y1, int x2, int y2){
        char temp = candies[x1][y1];
        candies[x1][y1] = candies[x2][y2];
        candies[x2][y2] = temp;
    }  

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();

        char [][]candies = new char[testCase][testCase];

        for(int i=0; i<candies.length; i++){
            String line = input.next();
            for(int j=0; j<candies[0].length; j++){
                candies[i][j] = (char) line.charAt(j);
            }
        }

        int ans = 0;

        for (int i=0; i<candies.length; i++){
            for(int j=0; j<candies[0].length; j++){
                
                // # 오른쪽
                if (j + 1 < candies[0].length && candies[i][j] != candies[i][j+1]){
                    // 스왑
                    candySwap(candies, i, j, i, j + 1);
                    // 카운트
                    ans = Math.max(ans, Math.max(findMaxColumn(candies), findMaxRow(candies)));
                    // 원상복귀
                    candySwap(candies, i, j, i, j + 1);
                }
               

                // # 아래
                    
                if(i + 1 < candies.length && candies[i][j] != candies[i+1][j]){
                    // 스왑
                    candySwap(candies, i, j, i + 1, j);
                    // 카운트
                    ans = Math.max(ans, Math.max(findMaxColumn(candies), findMaxRow(candies)));
                    // 원상복귀
                    candySwap(candies, i, j, i + 1, j);
                }
            
            }
        }

        System.out.println(ans);
    }
    
}
