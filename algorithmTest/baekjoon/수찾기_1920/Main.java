/*
 N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws Exception{
       BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
        	// 정렬
		Arrays.sort(arr);
		
		int t = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
        
		while(t-- > 0) {
			int target = Integer.parseInt(stk.nextToken());
			if(binarySearch(arr, target)) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
    }

    public static boolean binarySearch(int []arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end){
            mid = (start+end) / 2;
            if(arr[mid] == target) return true;
            else if (arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid - 1;
            }
        }
        return false;

    }

    
}
