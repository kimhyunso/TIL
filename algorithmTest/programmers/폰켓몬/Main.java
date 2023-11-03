package programmers.폰켓몬;

import java.util.*;

public class Main {

    public static void main(String[] args){
        int nums[] = {3, 1, 2, 3};
        solution(nums);
    }

    public static int solution(int[] nums){
        int answer = 0;
        //이름을 어떻게 지을껀가?
        Set<Integer> numsHashSet = new HashSet<>();
        for(int num : nums) {
            numsHashSet.add(num);
        }
        return numsHashSet.size() > nums.length/2 ? nums.length/2 : numsHashSet.size();
    }
    
}
