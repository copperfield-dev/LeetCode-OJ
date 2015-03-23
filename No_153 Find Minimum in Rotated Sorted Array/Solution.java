public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return Integer.MIN_VALUE;

        int lo = 0;
        int hi = num.length - 1;
        int mid = lo;
        while (num[lo] > num[hi]) {
            if (hi - lo == 1) {
                mid = hi;
                break;
            }

            mid = lo + (hi - lo) / 2;
            if (num[mid] > num[lo])
                lo = mid;
            else if (num[mid] < num[hi])
                hi = mid;
        }
        return num[mid];
    }
}