public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> answerSet = new LinkedList<List<Integer>>();

        Arrays.sort(S);
        int numOfAnswer = (int)(Math.pow(2, S.length));
        
        for (int binary = 0; binary < numOfAnswer; binary++) {
            int temp = binary;
            List<Integer> subAnswer = new ArrayList<Integer>();
            for (int i = 0; i < S.length; i++) {
                boolean flag = ((temp & 0x1) == 1);
                if (flag)
                    subAnswer.add(S[i]);
                temp >>= 1;
            }
            answerSet.add(subAnswer);
        }

        return answerSet;
    }
}