public class Solution {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.isEmpty() || num2.isEmpty())
            return "0";

        StringBuffer number1 = new StringBuffer(num1);
        StringBuffer number2 = new StringBuffer(num2);
        number1.reverse();
        number2.reverse();
        int len = number1.length() + number2.length();
        StringBuffer answer = new StringBuffer(len);
        answer.setLength(len);
        for (int i = 0; i < len; i++)           
            answer.setCharAt(i, '0');

        for (int i = 0; i < number1.length(); i++) {
            int digit1 = number1.charAt(i) - '0';
            int carry = 0;
            for (int j = 0; j < number2.length(); j++) {
                int digit2 = number2.charAt(j) - '0';
                int result = answer.charAt(i + j) - '0' + digit1 * digit2;
                answer.setCharAt(i + j, (char)(result % 10 + '0'));
                carry = result / 10;
                int k = i + j;
                while (carry != 0) {
                    k++;
                    int temp = answer.charAt(k) - '0';
                    answer.setCharAt(k, (char)((carry + temp) % 10 + '0'));
                    carry = (carry + temp) / 10;
                }
            }
        }

        int m = answer.length() - 1;
        while (answer.charAt(m) == '0') {
            answer.deleteCharAt(m);
            m--;
        }
        answer.reverse();

        return answer.toString();
    }
}