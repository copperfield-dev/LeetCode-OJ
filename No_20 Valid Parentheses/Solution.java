public class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> charStack = 
            new ArrayList<Character>(s.length());

        int numInStack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||
                s.charAt(i) == '{' ||
                s.charAt(i) == '[') {
                charStack.add(s.charAt(i));
                numInStack++;
            }  
            if (s.charAt(i) == ')') {
                if (charStack.isEmpty())
                    return false;
                char temp = charStack.get(numInStack - 1);
                if (temp != '(')
                    return false;
                else {
                    charStack.remove(numInStack - 1);
                    numInStack--;
                    continue;
                }
            }
            if (s.charAt(i) == '}') {
                if (charStack.isEmpty())
                    return false;
                char temp = charStack.get(numInStack - 1);
                if (temp != '{')
                    return false;
                else {
                    charStack.remove(numInStack - 1);
                    numInStack--;
                    continue;
                }
            }
            if (s.charAt(i) == ']') {
                if (charStack.isEmpty())
                    return false;
                char temp = charStack.get(numInStack - 1);
                if (temp != '[')
                    return false;
                else {
                    charStack.remove(numInStack - 1);
                    numInStack--;
                    continue;
                }
            }
        }
        if (charStack.isEmpty())
            return true;
        else 
            return false;
    }
}