public class Solution {
    public static int ceiling(int A[], int B[]) {            
        int medianA = (A.length - 1) / 2;
        int medianB = (B.length - 1) / 2;

        if (A.length == 1) {
            if (B.length == 1)
                return A[0] < B[0] ? A[0] : B[0];
            if (B.length % 2 != 0) {
                if (A[0] >= B[medianB])
                    return B[medianB];
                else if (A[0] <= B[medianB - 1])
                    return B[medianB - 1];
                else 
                    return A[0];
            }
            else {
                if (A[0] >= B[medianB + 1])
                    return B[medianB + 1];
                else if (A[0] <= B[medianB])
                    return B[medianB];
                else 
                    return A[0];
            }
        }
        else if (B.length == 1) {
            if (A.length % 2 != 0) {
                if (B[0] >= A[medianA])
                    return A[medianA];
                else if (B[0] <= A[medianA - 1])
                    return A[medianA - 1];
                else 
                    return B[0];
            }
            else {
                if (B[0] >= A[medianA + 1])
                    return A[medianA + 1];
                else if (B[0] <= A[medianA])
                    return A[medianA];
                else
                    return B[0];
            }
        }
        else {
            int cutLength = (A.length / 2) < (B.length / 2) ? (A.length / 2) : (B.length / 2);
            if (A[medianA] == B[medianB])
            	return A[medianA];
            else if (A[medianA] < B[medianB]) {
            	int[] newA = new int[A.length - cutLength];
            	int[] newB = new int[B.length - cutLength];
            	System.arraycopy(A, cutLength, newA, 0, A.length - cutLength);
            	System.arraycopy(B, 0, newB, 0, B.length - cutLength); 
            	return ceiling(newA, newB);
            }
            else {
            	int[] newA = new int[A.length - cutLength];
            	int[] newB = new int[B.length - cutLength];
            	System.arraycopy(A, 0, newA, 0, A.length - cutLength);
            	System.arraycopy(B, cutLength, newB, 0, B.length - cutLength); 
            	return ceiling(newA, newB);
            }
        }
    }

    public static int floor(int A[], int B[]) {
    	int medianA = A.length / 2;
        int medianB = B.length / 2;

        if (A.length == 1) {
            if (B.length == 1)
                return A[0] < B[0] ? B[0] : A[0];
            if (B.length % 2 != 0) {
                if (A[0] >= B[medianB + 1])
                    return B[medianB + 1];
                else if (A[0] <= B[medianB])
                    return B[medianB];
                else 
                    return A[0];
            }
            else {
                if (A[0] >= B[medianB])
                    return B[medianB];
                else if (A[0] <= B[medianB - 1])
                    return B[medianB - 1];
                else 
                    return A[0];
            }
        }
        else if (B.length == 1) {
            if (A.length % 2 != 0) {
                if (B[0] >= A[medianA + 1])
                    return A[medianA + 1];
                else if (B[0] <= A[medianA])
                    return A[medianA];
                else 
                    return B[0];
            }
            else {
                if (B[0] >= A[medianA])
                    return A[medianA];
                else if (B[0] <= A[medianA - 1])
                    return A[medianA - 1];
                else
                    return B[0];
            }
        }
        else {
            int cutLength = medianA < medianB ? medianA : medianB;
            if (A[medianA] == B[medianB])
            	return A[medianA];
            else if (A[medianA] < B[medianB]) {
            	int[] newA = new int[A.length - cutLength];
            	int[] newB = new int[B.length - cutLength];
            	System.arraycopy(A, cutLength, newA, 0, A.length - cutLength);
            	System.arraycopy(B, 0, newB, 0, B.length - cutLength); 
            	return floor(newA, newB);
            }
            else {
            	int[] newA = new int[A.length - cutLength];
            	int[] newB = new int[B.length - cutLength];
            	System.arraycopy(A, 0, newA, 0, A.length - cutLength);
            	System.arraycopy(B, cutLength, newB, 0, B.length - cutLength); 
            	return floor(newA, newB);
            }
        }
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if (m == 0) {
            if (n % 2 != 0)
                return B[(n - 1) / 2];
            else 
                return (B[(n - 1) / 2] + B[n / 2]) / 2.0;
        }
        if (n == 0) {
            if (m % 2 != 0)
                return A[(m - 1) / 2];
            else
                return (A[(m - 1) / 2] + A[m / 2]) / 2.0;
        }
        int total = m + n;
        if (total % 2 != 0)
            return ceiling(A, B);
        else
            return (ceiling(A, B) + floor(A, B)) / 2.0;
    }
}