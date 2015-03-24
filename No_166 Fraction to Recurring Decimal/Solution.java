public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return null;

        String fraction = "";
        String integralPart = "";
        String decimalPart = "";
        long n = numerator;
        long d = denominator;
        if ((n < 0 && d > 0) || (n > 0 && d < 0)) 
            fraction += "-";
        n = (n < 0)? Math.abs(n) : n;
        d = (d < 0)? Math.abs(d) : d;
        
        integralPart = String.valueOf(n / d);
        if (n % d == 0)
            return fraction += integralPart;
        else
            fraction += integralPart + ".";

        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        if (n > d)
            n %= d;
        int index = 0;
        while (n % d != 0) {
            /* 分为循环与不循环处理 */
            if (hashMap.get(n) == null) 
                hashMap.put(n, index);
            else {
                decimalPart = decimalPart.substring(0, hashMap.get(n)) +
                    "(" + decimalPart.substring(hashMap.get(n), index) + ")";
                break;
            }

            decimalPart += String.valueOf(n * 10 / d);
            index++;
            n = n * 10 % d;
        }
        
        return fraction += decimalPart;
    }
}