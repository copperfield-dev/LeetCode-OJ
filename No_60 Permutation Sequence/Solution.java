public class Solution {
    public String getPermutation(int n, int k) {
        if (k <= 0)
            return null;

        String str = "123456789".substring(0, n);
        StringBuilder answer = new StringBuilder();
        StringBuilder newStr = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            int temp = factorial(newStr.length() - 1);
            int index = (k - 1) / temp;
            answer.append(newStr.charAt(index));
            newStr.deleteCharAt(index);
            k -= index * temp;
        }
        return answer.toString();
    }

    //求正整数n的阶乘
    private int factorial(int n) {
        int res = 1;
        for(int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}