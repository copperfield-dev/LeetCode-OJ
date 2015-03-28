public class Solution {
    private List<List<String>> answerSet = new LinkedList<List<String>>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return answerSet;

        backtrack(s, 0, 0, new ArrayList<String>());
        return answerSet;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        if (start == end)
            return true;
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private void backtrack(String s, int index, int start, ArrayList<String> subAnswerSet) {
        if (index == s.length() && subAnswerSet.size() > 0) {
            List<String> copy = (ArrayList<String>)subAnswerSet.clone();
            answerSet.add(copy);
            return;
        }

        for (int i = 1; i < s.length() + 1 - start; i++) {
            if (!isPalindrome(s.substring(start, start + i)))
                continue;
            else {
                subAnswerSet.add(s.substring(start, start + i));
                backtrack(s, index + i, start + i, subAnswerSet);
                subAnswerSet.remove(subAnswerSet.size() - 1);
            }
        }
        return;
    }
}