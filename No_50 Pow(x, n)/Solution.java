public class Solution {
    private boolean invalidInput = false;
    public double pow(double x, int n) {
        invalidInput = false;
        if (equal(x, 0.0) && n < 0) {
            invalidInput = true;
            return 0.0;
        }
        
        int absExponent = n; 
        if (n < 0)
            absExponent = -n;

        double result = powWithUnsignedExponent(x, absExponent);
        if (n < 0)
            result = 1.0 / result;

        return result;
    }

    private boolean equal(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.0000001)
            return true;
        else
            return false;
    }

    public double powWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) 
            return 1;
        if (exponent == 1)
            return base;

        double result = pow(base, exponent >> 1);
        result *= result;
        if (exponent % 2 == 1)
            result *= base;

        return result;
    }
}