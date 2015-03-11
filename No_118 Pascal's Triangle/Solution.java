public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new LinkedList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> subAnswer = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    subAnswer.add(1);
                else if (j == i)
                    subAnswer.add(1);
                else
                    subAnswer.add(answer.get(i - 1).get(j) 
                        + answer.get(i - 1).get(j - 1));
            }
            answer.add(subAnswer);
        }
        return answer;
    }
}