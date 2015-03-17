public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
            return 2147483647;
        if (dividend == 0)
            return 0;

        long dv = Math.abs((long)dividend);
        long ds = Math.abs((long)divisor);
        if (dv < ds)
            return 0;

        long sum = 0;
        long count = 0;
        long result = 0;
        while (dv >= ds) {
            sum = ds;
            count = 1;
            while ((sum + sum) <= dv) {
                sum <<= 1;
                count <<= 1;
            }
            dv -= sum;
            result += count;
        }
        if ((dividend > 0) ^ (divisor > 0))
            result = -result;
        return (int)result;
    }
}