public class Solution {
    public int maxArea(int[] height) {
        int bottleneck = Math.min(height[0], height[height.length - 1]);
        int maxArea = bottleneck * (height.length - 1);

        int low = 0;
        int high = height.length - 1;
        int min = (height[low] < height[high])? low : high;

        while (low < high) {
            if (min == low) {
                while (height[++low] <= bottleneck && low < high);
                if (height[low] * (high - low) > maxArea) {
                    maxArea = height[low] * (high - low);
                    bottleneck = height[low];
                    min = (height[low] < height[high])? low : high;
                }
            }
            else if (min == high) {
                while (height[--high] <= bottleneck && high > low);
                if (height[high] * (high - low) > maxArea) {
                    maxArea = height[high] * (high - low);
                    bottleneck = height[high];
                    min = (height[low] < height[high])? low : high;
                }
            }            
        }
        return maxArea;
    }
}