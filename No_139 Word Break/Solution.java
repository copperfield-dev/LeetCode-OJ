public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0
         || dict == null || dict.size() == 0)
            return false;

        boolean[] answer = new boolean[s.length() + 1];
        answer[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i));
            for (int j = 0; j <= i - 1; j++) {
                if (answer[j] && dict.contains(str.toString())) {
                    answer[i] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return answer[s.length()];
    }
}