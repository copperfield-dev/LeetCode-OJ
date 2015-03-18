public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0)
            return 0;

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (sum <= 0)
                sum = A[i];
            else
                sum += A[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }
}