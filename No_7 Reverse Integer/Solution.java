public class Solution {
    public static int reverse(int x) {
		int sign = (x < 0)? -1 : 1;
		int result = 0;
		int digital;
		while (x != 0) {
			digital = x % 10;
			if (sign == 1) {
				if (result == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10) 
					return 0; 
				if (result > Integer.MAX_VALUE / 10) 
					return 0;
			}
			else if (sign == -1) {
				if (result == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10)
					return 0;
				if (result < Integer.MIN_VALUE / 10)
					return 0;
			}
			
			result = result * 10 + digital;
			x /= 10;
		}
		
		return result;
    }
}