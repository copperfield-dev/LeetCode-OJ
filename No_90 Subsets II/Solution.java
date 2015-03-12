public class Solution {
    private List<List<Integer>> answerSet = new LinkedList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null) 
            return answerSet;

        Arrays.sort(num);
        
        backtrack(num, 0, new ArrayList<Integer>());

        return answerSet;
    }

    public void backtrack(int[] num, int index, List<Integer> path) {
        answerSet.add(new ArrayList<Integer>(path));

        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i - 1])
                continue;
            
            path.add(num[i]);
            backtrack(num, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}