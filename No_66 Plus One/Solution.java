public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        if (digits[length - 1] != 9) {
            digits[length - 1]++;
            return digits;
        }
        else {
            for (int i = length - 1; i > 0; i--) {
                digits[i] = 0;
                if (digits[i - 1] != 9) {
                    digits[i - 1]++;
                    return digits;
                }
            }

            int[] newDigits = new int[length + 1];
            Arrays.fill(newDigits, 0);
            newDigits[0] = 1;
            return newDigits; 
        }
    }
}