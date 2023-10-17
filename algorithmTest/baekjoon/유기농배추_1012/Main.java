package baekjoon.유기농배추_1012;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(input.readLine());



        for (int i=0; i<testCase; i++){

            StringTokenizer token = new StringTokenizer(input.readLine(), " ");
            int width = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());
            int worm = Integer.parseInt(token.nextToken());

            int matrix[][] = new int[width][height];


            for (int j=0; j<width; j++){
                for (int k=0; k<height; k++){
                    matrix[j][k] = 0;
                }
            }

            for (int j=0; j<width; j++){
                for (int k=0; k<height; k++){
                    for (int v=0; v<worm; v++){
                        String temps[] = input.readLine().split(" ");
                        int x = Integer.parseInt(temps[0]);
                        int y = Integer.parseInt(temps[1]);
                        matrix[x][y] = 1;
                    }
                    System.out.println(matrix[j][k]);
                }
            }

        }

    }
}
