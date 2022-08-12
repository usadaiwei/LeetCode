package Examples.Algorithms.Bloomberg;
import java.util.HashMap;
/*
You are given an integer array nums that is sorted in non-decreasing order.
Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:

Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
All subsequences have a length of 3 or more.
Return true if you can split nums according to the above conditions, or false otherwise.
Example 1:
Input: nums = [1,2,3,3,4,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,5] --> 1, 2, 3
[1,2,3,3,4,5] --> 3, 4, 5

Example 2:
Input: nums = [1,2,3,3,4,4,5,5]
Output: true

Example 3:
Input: nums = [1,2,3,4,4,5]
Output: false
Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
 */

public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        HashMap<Integer, Integer> want = new HashMap<Integer, Integer>();

        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i])==0){
                continue;
            }
            // only 4, 5 will go through this logic
            if(want.getOrDefault(arr[i],0)>0){
                map.put(arr[i],map.get(arr[i])-1); // 4 or 5 才会在map里减1
                want.put(arr[i], want.getOrDefault(arr[i],0)-1);
                want.put(arr[i]+1, want.getOrDefault(arr[i]+1,0)+1);
            }
            // 1,2,3  or 3,4,5 will pass through this logic below
            else if(map.getOrDefault(arr[i],0)>0 && map.getOrDefault(arr[i]+1,0)>0 && map.getOrDefault(arr[i]+2,0)>0){
                map.put(arr[i],map.get(arr[i])-1);
                map.put(arr[i]+1,map.get(arr[i]+1)-1);
                map.put(arr[i]+2,map.get(arr[i]+2)-1);

                want.put(arr[i]+3, want.getOrDefault(arr[i]+3,0)+1); // 4, 5
            }else{
                return false;
            }
        }
        return true;
    }
}
