public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int maxProfit = 0;
        /*用两个DP数组分别保存左边和右边的利润最大值*/
        int[] leftProfit = new int[prices.length];    //计算[0, i]区间的最大值  
        int[] rightProfit = new int[prices.length];   // 计算[i, len-1]区间的最大值  
    
        dpcalculator(prices, leftProfit, rightProfit);


    }

    public void dpcalculator(int[] prices, int[] left, int[] right) {
        left[0] = 0;
        int minPrice = left[0];    //最低价买入
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);   //更新最低买入价
        }

        right[right.length - 1] = 0;
        int maxPrice = right[right.length - 1];   //
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
    }
} 