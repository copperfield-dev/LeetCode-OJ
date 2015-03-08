public class Solution {
    public int trailingZeroes(int n) {
        int i = 1;
        int countZero = 0;
        while (n >= Math.pow(5, i)) {
            countZero += n / (int)Math.pow(5, i);
            i++;
        }

        return countZero;
    }
}