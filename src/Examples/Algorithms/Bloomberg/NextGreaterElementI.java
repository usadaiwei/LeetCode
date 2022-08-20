package Examples.Algorithms.Bloomberg;

import java.util.HashMap;
import java.util.Map;

/*
496. Next Greater Element I
Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // num, index in array nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i])){
                int max = nums2[i];
                for (int j = i+1; j < nums2.length; j++){
                    if (nums2[j] > max){
                        max = nums2[j];
                        ans[map.get(nums2[i])] = max; // key
                        break;
                    }
                }

                if (max == nums2[i])
                    ans[map.get(nums2[i])] = -1; // key
            }
        }
        return ans;
    }
}
