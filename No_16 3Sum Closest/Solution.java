public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3)
            return Integer.MIN_VALUE;

        Arrays.sort(num);
        int closest = num[0] + num[1] + num[2] - target;
        for (int i = 0; i < num.length - 2; i++) {
            int curClosest = twoSum(num, i + 1, target - num[i]);
            if (Math.abs(curClosest) < Math.abs(closest))
                closest = curClosest;
        }
        return target + closest;
    }

    public int twoSum(int[] num, int start, int target) {
        if (num == null || num.length < 2)
            return Integer.MIN_VALUE;

        int closest = num[start] + num[start + 1] - target;

        int lo = start;
        int hi = num.length - 1;
        while (lo < hi) {
            if (num[lo] + num[hi] == target) 
                return 0;
            int diff = num[lo] + num[hi] - target;
            if (Math.abs(diff) < Math.abs(closest))
                closest = diff;
            else if (num[lo] + num[hi] > target)
                hi--;
            else if (num[lo] + num[hi] < target)
                lo++;   
        }

        return closest;
    }
}