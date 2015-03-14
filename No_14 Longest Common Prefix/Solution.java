public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestPrefix = new StringBuilder();
        if (strs == null || strs.length == 0)
            return longestPrefix.toString();

        for (int index = 0; index < strs[0].length(); index++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == index)
                    return longestPrefix.toString();
                if (strs[0].charAt(index) != strs[j].charAt(index))
                    return longestPrefix.toString();
            }
            longestPrefix.append(strs[0].charAt(index));
        }

        return longestPrefix.toString();
    }
}