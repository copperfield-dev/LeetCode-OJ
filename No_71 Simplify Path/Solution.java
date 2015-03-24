public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return null;

        LinkedList<String> stack = new LinkedList<String>();
        String[] tokens = path.split("/");
        
        for (String s: tokens) {
            if (s.length() == 0 || s.equals("."))
                continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(s);
        }
        
        if (stack.isEmpty())
            return "/";

        String ans = "";
        while (!stack.isEmpty()) 
            ans += "/" + stack.removeLast();
        
        return ans;
    }
}