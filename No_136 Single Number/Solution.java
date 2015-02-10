public class Solution {
    public int singleNumber(int[] A) {
        int answer = A[0];
        for (int i = 1; i < A.length; i++)          
            answer ^= A[i];

        return answer;
    }
}