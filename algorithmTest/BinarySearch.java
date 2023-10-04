import java.util.*;

public class BinarySearch {
    public static void main(String[] args){
        // 배열 초기화
        int arr[] = {6, 2, 7, 4, 5, 3};
        // 오름차순 정렬
        Arrays.sort(arr);
        int findKey = binarySearch(6, arr);
        System.out.println(findKey);
    }


    public static int binarySearch(int key, int arr[]){
        // key 6
        int mid;
        int left = 0;
        int right = arr.length-1;

        // [2, 3, 4, 5, 6, 7]
        // 1. 0 <= 5 : true
        // 2. 3 <= 5 : true
        while (left <= right){
            // 중앙값 찾기 
            // 1. (0 + 5) / 2 = 2
            // 2. (3 + 5) / 2 = 4
            mid = (left + right) / 2;

            // 1. 6 == 4 : false
            // 2. 6 == 6 : true
            if (key == arr[mid]){
                return arr[mid];
            // 6 < 4 : false
            }else if (key < arr[mid]){
                right = mid - 1;
            // 6 > 4 : true
            }else{
                // 3
                left = mid + 1;
            }

        }



        return -1;

    }
}
