package fastcampus.성지키기_1236;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");



        // N
        int height = Integer.parseInt(token.nextToken()); 
        // M
        int width = Integer.parseInt(token.nextToken());
        
        char casel[][] = new char[height][width];

        for (int i=0; i<height; i++){
            String line = input.readLine();
            for(int j=0; j<width; j++){
                casel[i][j] = line.charAt(j);
            }
        }

        // 1. 각 행/열에 대해 경비원이 있는지 확인한다.

        boolean[] existRow = new boolean[height];
        boolean[] existCol = new boolean[width];

        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if (casel[i][j] == 'X'){
                    existRow[i] = true;
                    existCol[j] = true;
                }
            }
        }
        


        // int existRowCount = 0;
        // for (int i=0; i<height; i++){
        //     boolean exist = false;
        //     for (int j=0; j<width; j++){
        //         if(casel[i][j] == 'X'){
        //             exist = true;
        //             break;
        //         }
        //     }
        //     if (exist) existRowCount++;
        // }


        // int existColCount = 0;
        // for (int i=0; i<width; i++){
        //     boolean exist = false;
        //     for (int j=0; j<height; j++){
        //         if(casel[j][i] == 'X'){
        //             exist = true;
        //             break;
        //         }
        //     }
        //     if (exist) existColCount++;
        // }


        // 2. 보호받지 못하는 행/열의 개수를 구한다.
        // int needRowCount = height - existRowCount;
        // int needColCount = width - existColCount;

        int needRowCount = height;
        int needColCount = width;
        
        for (int i=0; i<height; i++){
            if (existRow[i]) needRowCount--;
        }
        for (int i=0; i<width; i++){
            if (existCol[i]) needColCount--;
        }


        // O(N * M) + O(N * M) + O(N) + O(M) => O(NM)

        // 3. 둘 중 큰 값을 출력한다.
        System.out.println(Math.max(needRowCount, needColCount));

    }
    
}
