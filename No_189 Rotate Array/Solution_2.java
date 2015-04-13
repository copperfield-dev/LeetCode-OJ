public class Solution {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length)
            k %= nums.length;
        
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - k + i];    //第i个开始循环的数
            int p = nums.length - k + i;
            for (int j = 0; j < nums.length - k; j++) 
                nums[p] = nums[--p];
            nums[p] = temp;
        }
    }
}