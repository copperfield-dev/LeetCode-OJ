public class Solution {
    public boolean isPalindrome(String s) {
        String newS = s.trim().toLowerCase();
        int i = 0;
        int j = newS.length() - 1;
        
        while (i <= j) {
            while (newS.charAt(i) < '0' 
                || (newS.charAt(i) > '9' && newS.charAt(i) < 'a') 
                || newS.charAt(i) > 'z') {
                i++;
                if (i > j)
                    return true;
            }
            while (newS.charAt(j) < '0' 
                || (newS.charAt(j) > '9' && newS.charAt(j) < 'a') 
                || newS.charAt(j) > 'z') {
                j--;
                if (j < i)
                    return true;
            }
            if (newS.charAt(i) != newS.charAt(j)) 
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}