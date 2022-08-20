package Examples.Algorithms.Bloomberg;
/*
492. Construct the Rectangle
A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

The area of the rectangular web page you designed must equal to the given target area.
The width W should not be larger than the length L, which means L >= W.
The difference between length L and width W should be as small as possible.
Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.

Example 1:

Input: area = 4
Output: [2,2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i*i <= area; i++){
            if (area % i == 0){
                int L = area / i;
                int diff = area - i;
                if (L >= i && diff <= minDiff){
                    ans[0] = L;
                    ans[1] = i;
                }
            }
        }
        return ans;
    }
}
