public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;

        /* Manacher's Algorithm */
        String str = preString(s);
        int[] p = new int[str.length()];
        int id = 0, mx = 0;
        for (int i = 1; i < str.length() - 1; i++) {
            p[i] = (mx > i)? Math.min(p[2 * id - i], mx - i) : 1;
            while (str.charAt(i + p[i]) == str.charAt(i - p[i]))
                p[i]++;
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }

        int maxLen = 0, index = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                index = i;
            }       
        }
        return s.substring((index - maxLen) / 2, (index + maxLen) / 2 - 1);   
    }

    public String preString(String s) {
        StringBuilder str = new StringBuilder();
        str.append('$');
        str.append('#');
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            str.append('#');
        }
        str.append('^');
        return str.toString();
    }
}