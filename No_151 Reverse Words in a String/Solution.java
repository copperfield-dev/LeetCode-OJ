public class Solution {
    public String reverseWords(String s) {
        if (s == null) 
            return null;
        if (s.isEmpty())
            return "";
            
        Stack<String> stack = new Stack<String>();
        int index = 0;
        String temp = "";
        while (index < s.length()) {
            if (s.charAt(index) != ' ') 
                temp += s.charAt(index);
            else if (temp != "") {
                stack.push(temp);
                temp = "";
            }
            index++;
        }
        if (temp != "")
            stack.push(temp);

        String reverseS = "";
        while (stack.size() > 1) {
            reverseS += stack.pop();
            reverseS += " ";
        }
        if (stack.isEmpty())
            return "";          //字符串s全部是空格
        else 
            reverseS += stack.pop();
        return reverseS;
    }
}