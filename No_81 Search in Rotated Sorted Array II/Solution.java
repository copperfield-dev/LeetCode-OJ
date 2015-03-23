public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0)
            return false;

        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < A[mid]) {
                if (target >= A[lo]) 
                    hi = mid - 1;
                else if (mid != A.length - 1 && A[mid + 1] <= A[mid])
                    lo = mid + 1;
                else if (mid == A.length - 1)
                    return false;
            }
            else if (target > A[mid]) {
                if (target <= A[hi])
                    lo = mid + 1;
                else if (mid != 0 && A[mid - 1] >= A[mid])
                    hi = mid - 1;
                else if (mid == 0)
                    return false;
            }
            else
                return true;
        }
        return false;
    }
}