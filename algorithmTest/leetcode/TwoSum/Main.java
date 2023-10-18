package leetcode.TwoSum;

public class Main {
    public static void main(String[] args){

        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = twoSum(nums, target);

        for (int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }


    public static int[] twoSum(int[] nums, int target){
        int targets[] = new int[2];

        for (int i=0; i<nums.length; i++){

            for (int j=i+1; j<nums.length; j++){
                if ((nums[i] + nums[j]) == target){
                    targets[0] = i;
                    targets[1] = j;
                    break;
                }
            }
        }

        return targets;
    }
}
