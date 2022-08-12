package Examples.DataStructures.Arrays;

import java.util.HashMap;

/*
Max Consecutive Ones (Easy)
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0)
            return 0;

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                count++;
                if (count > map.getOrDefault(1, 0)){
                    map.put(1, count);
                }
            } else {
                count = 0;
            }
        }
        return map.get(1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
