public class Solution {
    private List<String> answerSet = new LinkedList<String>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12)
            return answerSet;

        backtrack(s, 0, 0, new StringBuilder(s.length() + 3));
        return answerSet;
    }

    private void backtrack(String s, int index, int start, StringBuilder subAnswer) {
        if (index == 4) {
            subAnswer.deleteCharAt(subAnswer.length() - 1);
            answerSet.add(subAnswer.toString());
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index == 3 && start + i < s.length())
                continue;
            if (start + i < s.length() + 1) {
                if (Integer.valueOf(s.substring(start, start + i)) > 255) 
                    continue;
                if (i > 1 && s.charAt(start) == '0')
                    continue;
                subAnswer.append(s.substring(start, start + i) + ".");
                backtrack(s, index + 1, start + i, subAnswer);
                subAnswer.delete(start + index, start + i + index + 1);
            }
            else
                continue; 
        }
        return;
    }
}