public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> answer = new ArrayList<Integer>();
        if (n == 0) {
            answer.add(new Integer(0));
            return answer;
        }
        
        answer = grayCode(n - 1);
        int addNum = 1 << (n - 1);
        int latterSize = answer.size();

        for (int i = latterSize - 1; i >= 0; i--)
            answer.add(answer.get(i) + addNum);
        return answer;
    }
}