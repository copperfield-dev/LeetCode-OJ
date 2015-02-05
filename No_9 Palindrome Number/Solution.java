public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        
        int divisor = 1;

        while ((x / divisor) >= 10)
            divisor *= 10;

        System.out.println(divisor);
        while (x != 0) {
            int digitLast = x % 10;
            int digitFirst = x / divisor;
            if (digitFirst != digitLast)
                return false;

            x = (x - digitFirst * divisor) / 10;
            divisor /= 100;
        }
        return true;
    }
}