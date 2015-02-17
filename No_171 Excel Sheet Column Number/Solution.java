public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int i = 0;
        int answer = 0;
        while (i < len) {
            char title = s.charAt(i);
            answer += (title - 'A' + 1) * Math.pow(26, len - i - 1);
            i++;
        }
        return answer;
    }
}