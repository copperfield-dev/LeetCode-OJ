public class Solution {
    public String convertToTitle(int n) {
        StringBuffer answer = new StringBuffer();
        while (n != 0) {
            int digit = n % 26;
            if (n % 26 == 0) {
                digit = 26;
                n -= 26;
            }
            answer.append((char)('A' + digit - 1));
            n /= 26;
        }
        return (answer.reverse().toString());
    }
}