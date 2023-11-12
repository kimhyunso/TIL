package fastcampus.개미_10158;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");
    
        int W = Integer.parseInt(token.nextToken());
        int H = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(input.readLine(), " ");

        int P = Integer.parseInt(token.nextToken());
        int Q = Integer.parseInt(token.nextToken());
    
        int T = Integer.parseInt(input.readLine());
    


        // int currentX = (T + P) % (2 * W);
        // int currentY = (T + Q) % (2 * H);

        // if (currentX > W) currentX = 2 * W - currentX;
        
        // if (currentY > H) currentY = 2 * H - currentY;


        int timeX = T % (2 * W);
        int currentX = P;
        int deltaX = 1;

        while(timeX-- > 0){
            if (currentX == W) deltaX = -1;
            else if (currentX == 0) deltaX = 1;

            currentX += deltaX;
        }


        int timeY = T % (2 * H);
        int currentY = Q;
        int deltaY = 1;

        while(timeY-- > 0){
            if (currentY == H) deltaY = -1;
            else if (currentY == 0) deltaY = 1;

            currentY += deltaY;
        }

        System.out.print(currentX + " " + currentY);
        
    }

    
}
