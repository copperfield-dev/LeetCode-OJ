public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int count = 1;
        int countSingle = 1;

        /* 不使用额外数组完成动态规划 */
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                int tempCount = count;    //直接添加多少个一位数
                int temp = Integer.parseInt(s.substring(i - 1, i + 1)); 
                if (temp <= 26 && temp >= 10)
                    count += countSingle;
                countSingle = tempCount;
            }
            else {
                int temp = Integer.parseInt(s.substring(i - 1, i + 1)); 
                if (temp == 10 || temp == 20) {
                    count = countSingle;
                    countSingle = 0;
                }
                else
                    return 0;
            }
        }

        return count;
    }
}