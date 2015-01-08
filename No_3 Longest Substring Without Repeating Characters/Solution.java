public class Solution {
    public static  int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<Character>(35);
        int length = 0;
        int maxLength = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            char charTemp = s.charAt(i);
            if (!charSet.contains(charTemp)) {
                length++;
                charSet.add(charTemp);
            }
            else {
                while (s.charAt(j) != charTemp) {
                    charSet.remove(s.charAt(j));
                    j++;
                    length--;
                }
                j = j + 1;
            }
            
            if (length > maxLength)
                maxLength = length;
        }

        return maxLength;
    }
}

