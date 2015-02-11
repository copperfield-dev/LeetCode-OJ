public class Solution {
    public int lengthOfLastWord(String s) {
        int lengthOfLastWord = 0;
        if (s == null || s.isEmpty())            
            return lengthOfLastWord;

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            lengthOfLastWord++;
            i--;
        }

        return lengthOfLastWord;
    }
}