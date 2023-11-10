import java.util.*;
import java.io.*;

/**
 * 1. 아이디어
 * - N개의 수 정렬[O(N log N)]
 * - M개를 for 돌면서, 이진탐색
 * - 이진탐색 안에서 마지막에 데이터 찾으면, 1출력, 아니면 0
 * 
 * 2. 시간복잡도
 * - O(N log N) 정렬
 * - O(M log N) 이진탐색
 * - 2^10 = 10^3
 * - O((N+M) log N) = 2e5 * 20 = 4e6 > 가능
 * 
 * 3. 자료구조
 * - N개 숫자: int[]
 * - M개 숫자 : int[]
 */


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
