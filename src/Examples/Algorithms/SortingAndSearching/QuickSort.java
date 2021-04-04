package Examples.Algorithms.Sorting;

/* Quick Sort: Find a mid, put smaller elements to its left side, put larger elements to its right side.
 Left: point to the first element of array
 Right: point to the last element of array
 */
public class QuickSort {
    public static void quickSort(int[] array, int L, int R){
        int i = L;
        int j = R;
        int mid = array[(L + R) / 2];

        while (i <= j){

            while (mid > array[i]){
                i++;
            }

            while (mid < array[j]){
                j--;
            }

            if (i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (L < j){
            quickSort(array, L, j);
        }

        if (i < R){
            quickSort(array, i, R);
        }
    }
}
