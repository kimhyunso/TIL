package fastcampus.성지키기_1236;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");

        int height = Integer.parseInt(token.nextToken());
        int width = Integer.parseInt(token.nextToken());
        
        char casel[][] = new char[height][width];

        for (int i=0; i<height; i++){
            String line = input.readLine();
            for(int j=0; j<width; j++){
                casel[i][j] = line.charAt(j);
            }
        }

        int rowCount = 0;
        for (int i=0; i<height; i++){
            if (rowCount == width){
                casel[i][i+1] = 'X';
            }
            rowCount = 0;

            for (int j=0; j<width; j++){
                if (casel[i][j] == 'X'){
                    rowCount = 0;
                }
                rowCount ++;
            }
        }


        int colCount = 0;
        for (int i=0; i<width; i++){
            if (rowCount == width){
                casel[i][i+1] = 'X';
            }
            colCount = 0;

            for (int j=0; j<height; j++){
                if (casel[i][j] == 'X'){
                    colCount = 0;
                }
                colCount ++;
            }
        }


    }
    
}
