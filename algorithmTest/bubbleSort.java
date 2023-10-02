import java.io.*;
import java.util.*;

public class bubbleSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String []numbers = br.readLine().split(" ");
        int[] bubbleSort = new int[N];

        int cnt = 0;
        int temp = 0;

        for (int i=0; i<N; i++){
            bubbleSort[i] = Integer.parseInt(numbers[i]);
        }

        for (int i=0; i<bubbleSort.length; i++){
            for (int j=0; j<bubbleSort.length-1; j++){
                if (bubbleSort[i] < bubbleSort[j]){
                    temp = bubbleSort[i];
                    bubbleSort[i] = bubbleSort[j];
                    bubbleSort[j] = temp;                   
                    cnt ++;
                }

            }

        }
    
        System.out.println(cnt);
    }

    
}
