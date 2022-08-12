package Examples.Algorithms.Bloomberg;

import java.util.HashMap;
import java.util.Map;

/*
Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Example 1:

Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
Example 2:

Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
Example 3:

Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6

 */

public class DotProductOfTwoSparseVectors {
    Map<Integer, Integer> map;

    DotProductOfTwoSparseVectors(int[] nums) {
        this.map = new HashMap<>();

        int count = -1;
        for (int i : nums){
            count++;
            this.map.put(count, i);
        }
        count = -1;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors vec) {
        int sum = 0;
        for (int i = 0; i < this.map.size() - 1; i++){
            sum += this.map.get(i) * vec.map.get(i);
        }
        return sum;
    }
}
