public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0)
            return -1;

        if (num.length == 1)
            return 0;
        int lo = 0;
        int hi = num.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == 0) {
                if (num[mid] > num[mid + 1])
                    return mid;
                else
                    lo = mid + 1;
            }
            else if (mid == num.length - 1) {
                if (num[mid - 1] < num[mid])
                    return mid;
                else
                    return hi = mid - 1;
            }
            else if (num[mid - 1] < num[mid] && num[mid] > num[mid + 1])
                return mid;
            else if (num[mid] < num[mid + 1])
               lo = mid + 1;
            else if (num[mid - 1] > num[mid])
                hi = mid - 1;
        }
        return -1;
    }
}