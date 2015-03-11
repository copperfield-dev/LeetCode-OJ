public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> answerK = new ArrayList<Integer>(rowIndex + 1);
        /* 数组初始化 */
        for (int k = 0; k < rowIndex + 1; k++)           
            answerK.add(0);  

        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i)
                    answerK.set(j, 1);
                else if (j == 0)
                    answerK.set(0, 1);
                else
                    answerK.set(j, answerK.get(j) + answerK.get(j - 1));
            }
        }
        return answerK;
    }
}