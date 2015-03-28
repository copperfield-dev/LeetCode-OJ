public class Solution {
    private List<String> answerSet = new LinkedList<String>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0)
            return answerSet;

        int leftParenthesis = 0;
        backtrack(n, 0, leftParenthesis, leftParenthesis, new StringBuilder(2 * n));
        return answerSet;
    }

    private void backtrack(int n, int index, int countLeft, int totalLeft, StringBuilder subAnswer) {
        if (index == 2 * n) {
            answerSet.add(subAnswer.toString());
            return;
        }

        char[] c = {'(', ')'};
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                if (totalLeft < n) {
                    subAnswer.append(c[i]);
                    backtrack(n, index + 1, countLeft + 1, totalLeft + 1, subAnswer);
                    subAnswer.deleteCharAt(subAnswer.length() - 1);
                }
                else
                    continue;   
            }
            else {
                if (countLeft > 0) {
                    subAnswer.append(c[i]);
                    backtrack(n, index + 1, countLeft - 1, totalLeft, subAnswer);
                    subAnswer.deleteCharAt(subAnswer.length() - 1);
                }
                else 
                    continue;
            }                
        }
        return;
    }
}