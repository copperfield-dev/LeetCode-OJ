public class Solution {
    public int atoi(String str) {
      if (str == null)
            return 0;
        if ("".equals(str))
            return 0;

        int number = 0;
        int i = 0;
        while (str.charAt(i) == ' ')
            i++;
        int sign = (str.charAt(i) == '-')? -1 : 1;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            i++;
        while ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
            if (sign == 1) {
                if (number == Integer.MAX_VALUE / 10 
                    && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)
                    return Integer.MAX_VALUE;
                if (number > Integer.MAX_VALUE / 10)
                    return Integer.MAX_VALUE;
            }
            else if (sign == -1) {
                if ((sign * number) == Integer.MIN_VALUE / 10 
                    && (sign * (str.charAt(i) - '0')) < Integer.MIN_VALUE % 10)
                    return Integer.MIN_VALUE;
                if ((sign * number) < Integer.MIN_VALUE / 10)
                    return Integer.MIN_VALUE;
            }
            
            number = number * 10 + (str.charAt(i) - '0');
            i++;
            if (i == str.length())
                break;
        }

        return sign * number;
    }
}