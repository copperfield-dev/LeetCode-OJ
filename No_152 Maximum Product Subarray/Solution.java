public class Solution {
    public int maxProduct(int[] A) {
        if (A.length == 1)
            return A[0];
        
        int maxLocal = A[0];
        int minLocal = A[0];
        int global = A[0];

        for (int i = 1; i < A.length; i++) {
            int tempMaxLocal = maxLocal;
            maxLocal = Math.max(Math.max(maxLocal * A[i], A[i]), minLocal * A[i]);
            minLocal = Math.min(Math.min(minLocal * A[i], A[i]), tempMaxLocal * A[i]);
            global = Math.max(global, maxLocal);
        }

        return global;
    }
}