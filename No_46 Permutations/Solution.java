public class Solution {
    private List<List<Integer>> answerSet = new LinkedList<List<Integer>>();

    public List<List<Integer>> permute(int[] num) {
        if (num == null)
            return answerSet;

        backtrack(num, 0);
        return answerSet;
    }

    public void backtrack(int[] num, int index) {
        if (index >= num.length) {
            List<Integer> path = new ArrayList<Integer>();
            for (int j = 0; j < num.length; j++) 
                path.add(num[j]);
            answerSet.add(path);
        }
            

        for (int i = index; i < num.length; i++) {
            swap(num, index, i);
            backtrack(num, index + 1);
            swap(num, index, i);
        }
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}