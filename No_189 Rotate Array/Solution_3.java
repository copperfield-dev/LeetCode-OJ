public class Solution {
	public void reverse(int[] nums, int start, int end) {
		for (; start < end; start++, end--) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
		}
	}

    public void rotate(int[] nums, int k) {
        if (k >= nums.length)
            k %= nums.length;
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
}
