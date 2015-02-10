public class Solution {
    public String addBinary(String a, String b) {
        char carry = '0';

        int len = (a.length() < b.length()) ? b.length() : a.length();
        
        StringBuffer answer = new StringBuffer();
        answer.setLength(len);

        int i = a.length() - 1;
        int j = b.length() - 1;
        while (len >= 1) {
            int numberOfOne = 0;
            if (i != -1) {
                if (a.charAt(i) == '1') 
                    numberOfOne++;
                i--;
            }
            if (j != -1) {
                if (b.charAt(j) == '1')
                    numberOfOne++;
                j--;
            } 
            if (carry == '1')
                numberOfOne++;
            switch (numberOfOne) {
                case 0: 
                    answer.setCharAt(len - 1, '0');
                    carry = '0';
                    break;
                case 1: 
                    answer.setCharAt(len - 1, '1');
                    carry = '0';
                    break;
                case 2:
                    answer.setCharAt(len - 1, '0');
                    carry = '1';
                    break;
                case 3:
                    answer.setCharAt(len - 1, '1');
                    carry = '1';
                    break;
            }
            len--;  
        }
        if (carry == '1') 
            return "1" + answer.toString();
        else
            return answer.toString();
    }
}