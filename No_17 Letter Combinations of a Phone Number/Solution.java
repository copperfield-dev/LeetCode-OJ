public class Solution {
    private List<String> answerSet = new LinkedList<String>();

    private char[][] keyboard =
    {
        {},                         // 0
        {},                         // 1
        {'a', 'b', 'c'},            // 2
        {'d', 'e', 'f'},            // 3
        {'g', 'h', 'i'},            // 4
        {'j', 'k', 'l'},            // 5
        {'m', 'n', 'o'},            // 6
        {'p', 'q', 'r', 's'},       // 7
        {'t', 'u', 'v'},            // 8
        {'w', 'x', 'y', 'z'}        // 9
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits))
            return answerSet;

        backtrack(digits, 0, new StringBuilder(digits.length()));
        return answerSet;
    }

    public void backtrack(String digits, int index, StringBuilder subAnswer) {
        if (index == digits.length()) {
            answerSet.add(subAnswer.toString());
            return;
        }
            

        int ncandidates = keyboard[digits.charAt(index) - '0'].length;
        char[] c = keyboard[digits.charAt(index) - '0'];

        for (int i = 0; i < ncandidates; i++) {
            subAnswer.append(c[i]);
            backtrack(digits, index + 1, subAnswer);
            subAnswer.deleteCharAt(subAnswer.length() - 1);
        }
    }
}