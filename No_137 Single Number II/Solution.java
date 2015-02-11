public class Solution {
    public int singleNumber(int[] A) {
        int[] bitNum = new int[32]; 
        for (int i = 0; i < bitNum.length; i++)
            bitNum[i] = 0;
        int singleNumber = 0;
        for (int i = 0; i < bitNum.length; i++) {
            for (int j = 0; j < A.length; j++) {
                bitNum[i] += (A[j] >> i) & 1;
            }
            singleNumber |= (bitNum[i] % 3) << i;
        }

        return singleNumber;
    }
}