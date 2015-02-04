public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i != -1 && j != -1) {
            if (A[i] >= B[j]) {
                A[k] = A[i];
                i--;
                k--;
            }
            else {
                A[k] = B[j];
                j--;
                k--;
            }
        }

        if (i == -1) 
            System.arraycopy(B, 0, A, 0, j + 1);
    }
}