public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] range = {-1, -1};
        if (A.length == 0)
            return range;

        int lo = 0;
        int hi = A.length - 1;
        int mid = binarySearch(lo, hi, A, target);
        if (mid == -1)
            return range;           //判断是否找到target

        int former = mid, latter = mid;
        while (former > 0 && A[former - 1] == target) 
            former = binarySearch(0, former - 1, A, target);
        while (latter < A.length - 1 && A[latter + 1] == target)
            latter = binarySearch(latter + 1, A.length - 1, A, target);

        range[0] = former;
        range[1] = latter;
        return range;
    }

    public int binarySearch(int start, int end, int[] A,int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < A[mid])
                end = mid - 1;
            else if (target > A[mid]) 
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}