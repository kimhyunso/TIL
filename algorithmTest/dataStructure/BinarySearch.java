package dataStructure;
import java.util.*;

class Main  {
    public static void main(String[] args){
        int numbers[] = {1, 13, 25, 36, 19};
        Arrays.sort(numbers);
        int target = 38;

        System.out.println(binarySearch(target, numbers));
    }

    public static int binarySearch(int target, int numbers[]){

        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;

            if (numbers[mid] == target)
                return numbers[mid];
            else if(numbers[mid] < target)
                left = mid + 1;
            else if(numbers[mid] > target)
                right = mid - 1;
        }

        return -1;
    }
    
}
