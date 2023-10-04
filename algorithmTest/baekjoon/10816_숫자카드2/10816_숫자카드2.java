import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cardN[] = new int[N];
        int cnt = 0;

        while (st.hasMoreTokens()){
            cardN[cnt++] = Integer.parseInt(st.nextToken());
        }

      
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int cardM[] = new int[M];
        cnt = 0;

        while (st.hasMoreTokens()){
            cardM[cnt++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardN);



        for (int i=0; i<cardM.length; i++){
            int lowerBound = lowerBound(cardM[i], cardN);
            int upperBound = upperBound(cardM[i], cardN);
            sb.append((lowerBound + upperBound) + " ");
        }

        System.out.print(sb.toString());
    }


    public static int lowerBound(int key, int arr[]){
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while(left < right){
            mid = (left + right) / 2;
            
            if (key <= arr[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public static int upperBound(int key, int arr[]){
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left < right){
            mid = (left + right) / 2;

            if (key < arr[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

}