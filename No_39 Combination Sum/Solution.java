public class Solution {
    private List<List<Integer>> answerSet = new LinkedList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || candidates == null)
            return answerSet;

        backtrack(0, target, 0, new ArrayList<Integer>(), candidates);
        return answerSet;
    }

    public void backtrack(int index, int target, int sum, 
        List<Integer> subAnswer, int[] c) {
        /* 找到答案 */
        if (sum == target) {
            answerSet.add(new ArrayList<Integer>(subAnswer));
            return;
        }

        /* 一次不成功的回溯 */
        if (sum > target || index > target) {
            c = construct_candidates(c);
            return;
        }

        int ncandidates = c.length;
        for (int i = 0; i < ncandidates; i++) {
            if (subAnswer.isEmpty() || c[i] >= subAnswer.get(subAnswer.size() - 1)) {
                sum += c[i];
                subAnswer.add(c[i]);
                backtrack(index + 1, target, sum, subAnswer, c);
                sum -= c[i];
                subAnswer.remove(subAnswer.size() - 1);
            }
        }
    }

    /* 删除掉一个失去意义的元素 */
    public int[] construct_candidates(int[] c) {
        int[] temp = new int[c.length - 1];
        System.arraycopy(c, 1, temp, 0, c.length - 1);
        return temp;
    }
}