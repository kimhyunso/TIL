import java.util.*;
import java.io.*;


public class Test {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());
        int nNums[] = new int[N];

        StringTokenizer token = new StringTokenizer(input.readLine(), " ");

        for (int i=0; i<N; i++){
            nNums[i] = Integer.parseInt(token.nextToken()); 
        }

        int M = Integer.parseInt(input.readLine());
        int mNums[] = new int[M];
        token = new StringTokenizer(input.readLine(), " ");

        for (int i=0; i<M; i++){
            mNums[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(nNums);

        for (int i=0; i<mNums.length; i++){
            int findNum = mNums[i];
            System.out.println(binarySearch(findNum, nNums));
        }

    }

    public static int binarySearch(int findNum, int nNums[]){
        int left = 0;
        int right = nNums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if (nNums[mid] == findNum){
                return 1;
            }else if (nNums[mid] < findNum){
                left = mid + 1;
            }else if(nNums[mid] > findNum){
                right = mid - 1;
            }
        }

        return 0;
    }
    
}
