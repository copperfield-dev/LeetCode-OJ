public class Solution {
    public String intToRoman(int num) {
        String result = "";

        int value[] = {1000, 900, 500, 400, 
                        100,  90,  50,  40,
                         10,   9,   5,   4, 1};
        String stringRoman[] = {"M", "CM", "D", "CD",
                                "C", "XC", "L", "XL", 
                                "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                result += stringRoman[i];
                num -= value[i];
            }
        }
        return result;
    }
}
