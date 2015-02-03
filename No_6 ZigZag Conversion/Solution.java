public class Solution {
    public String convert(String s, int nRows) {
        String returnString = "";
        int n = 0;

        if (nRows == 1)        
            return s;

        for (int i = 0; i < s.length(); 
            i += (nRows + nRows - 2)) {
            returnString += s.charAt(i);
        }
        n++;

        while (n < nRows - 1) {
            int cutlength = 0;
            boolean flag = true;
            for (int i = n; i < s.length(); i += cutlength) {
                returnString += s.charAt(i);
                if (flag) {
                    cutlength = 2 * nRows - 2 * (n + 1);
                    flag = false;
                }
                else {
                    cutlength = 2 * n;
                    flag = true;
                }
            }
            n++;
        }

        if (n == nRows - 1) {
            for (int i = nRows - 1; i < s.length(); 
                i += (nRows + nRows - 2)) {
                returnString += s.charAt(i);
            } 
        }
        
        return returnString;    
    }
}