public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 1; i <= 32; i++) {
            int temp = n & 0x1; 
            answer |=  temp << (32 - i);
            n = n >>> 1;
        }
        return answer;
    }
}