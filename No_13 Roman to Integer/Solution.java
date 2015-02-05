public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int tempNumber = 0;
        int tempNextNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            tempNumber = getInt(s.charAt(i));
            result += tempNumber;
            if (i != (s.length() - 1))
                tempNextNumber = getInt(s.charAt(i + 1));
            
            if (tempNumber < tempNextNumber)
                result -= 2 * tempNumber; 
        }
        return result;
    }

    public static int getInt(char c) {
        switch (c) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }
}