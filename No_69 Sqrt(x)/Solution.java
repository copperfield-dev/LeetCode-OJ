public class Solution {
    public int sqrt(int x) {
        long lo = 0;
        long hi = x / 2 + 1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long product = mid * mid;
            if (product == x)
                return (int)mid;
            else if (product < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return (int)hi;
    }
}