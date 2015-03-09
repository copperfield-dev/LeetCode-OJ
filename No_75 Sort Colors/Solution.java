public class Solution {
    public void sortColors(int[] A) {
        int low = 0, high = A.length - 1;
        if (high <= low) 
            return;
        int lt = low, i = low, gt = high;
        int v = 1;
        while (i <= gt) {
            if (A[i] < v) {
                int temp = A[lt];
                A[lt] = A[i];
                A[i] = temp;
                i++;
                lt++;
            }
            else if (A[i] > v) {
                int temp = A[i];
                A[i] = A[gt];
                A[gt] = temp;
                gt--;
            }
            else 
                i++;
        }
    }
}