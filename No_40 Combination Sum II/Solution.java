public class Solution {
    private List<List<Integer>> answerSet = new LinkedList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (num.length == 0 || num == null)
            return answerSet;

        Arrays.sort(num);
        backtrack(0, target, 0, new ArrayList<Integer>(), num);
        return answerSet;
    }

    public void backtrack(int index, int target, int sum, 
        List<Integer> subAnswer, int[] num) {
        if (sum == target) {
            answerSet.add(new ArrayList<Integer>(subAnswer));
            return;
        }

        if (sum > target) 
            return;

        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i - 1])
                continue;
            sum += num[i];
            subAnswer.add(num[i]);
            backtrack(i + 1, target, sum, subAnswer, num);
            sum -= num[i];
            subAnswer.remove(subAnswer.size() - 1);
        }
    }
}