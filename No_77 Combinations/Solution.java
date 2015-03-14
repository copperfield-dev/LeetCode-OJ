public class Solution {
    private List<List<Integer>> answerSet = new LinkedList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k || n <= 0)
            return answerSet;
        
        backtrack(1, n, k, new ArrayList<Integer>());
        return answerSet;
    }

    public void backtrack(int index, int n, int k, ArrayList<Integer> subAnswer) {
        if (subAnswer.size() == k) {
            answerSet.add(new ArrayList<Integer>(subAnswer));
            return;
        }

        for (int i = index; i <= n; i++) {
            subAnswer.add(i);
            backtrack(i + 1, n, k, subAnswer);
            subAnswer.remove(subAnswer.size() - 1);
        }
    }
}