package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

/* Assign Cookies (Easy)
Input: grid[1,3], size[1,2,4]
Output: 2
 */
public class AssignCookies {
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);

        int i = 0, j = 0;
        while (i < grid.length && j < size.length) {
            if (grid[i] <= size[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
