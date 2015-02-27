public class Solution {
    public int climbStairs(int n) {
        int ways[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0)
                ways[i] = 0;
            else if (i == 1)
                ways[i] = 1;
            else if (i == 2)
                ways[i] = ways[i - 1] + 1;
            else 
                ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
}