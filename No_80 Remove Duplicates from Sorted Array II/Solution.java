public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        
        boolean isSecond = false;
        int length = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[length] && !isSecond) {
                A[++length] = A[i];
                isSecond = true;  
            }

            if (A[i] != A[length]) {
                A[++length] = A[i];
                isSecond = false;
            }
        }

        return length + 1;
    }
}