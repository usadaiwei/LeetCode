package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

/*
881. Boats to Save People
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int result=0;
        while(i<j){
            int temp = people[i]+people[j];
            if(temp<=limit){
                result++;
                i++;
                j--;
            }
            else{
                result++;
                j--;
            }
        }
        if(i==j)
            result++;
        return result;
    }
}
