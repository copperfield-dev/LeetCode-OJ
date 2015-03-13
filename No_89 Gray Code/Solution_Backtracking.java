public class Solution {
    private List<Integer> answer = new ArrayList<Integer>();

    public List<Integer> grayCode(int n) {
        if (n < 0)
            return answer;

        backtrack(n, 0, new int[n]);
        return answer;
    }

    public void backtrack(int n, int index, int[] a) {
        if (index == n) {
            int temp = 0;
            for (int j = 0; j < a.length; j++)
                temp += a[j] * (int)(Math.pow(2, n - 1 - j));
            Integer subAnswer = new Integer(temp);
            answer.add(subAnswer);
            return;
        }

        int ncandidates = 2;
        int[] c = {0, 1};
        for (int i = 0; i < ncandidates; i++) {
            a[index] = c[i];
            backtrack(n, index + 1, a);
        }
    }
}