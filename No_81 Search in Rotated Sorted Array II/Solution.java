public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0)
            return false;

        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (A[mid] == target)
                return true;
            if (A[lo] < A[mid]) {           //left subsequence sorted
                if (A[lo] <= target && target < A[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else if (A[mid] < A[hi]) {      //right subsequence sorted
                if (A[hi] >= target && target > A[mid])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            else if (A[lo] == A[mid])
                lo++;
            else if (A[mid] == A[hi])
                hi--;
        }
        return false;
    }
}