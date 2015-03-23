public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        LinkedList<Integer> stack = new LinkedList<Integer>();
        int i = 0;
        while (i < tokens.length) {
            if (tokens[i].equals("+") || tokens[i].equals("-")
             || tokens[i].equals("*") || tokens[i].equals("/")) {
                int numOne = stack.pop();
                int numTwo = stack.pop();
                switch (tokens[i]) {
                    case "+": 
                        stack.push(numTwo + numOne);
                        break;
                    case "-":
                        stack.push(numTwo - numOne);
                        break;
                    case "*":
                        stack.push(numTwo * numOne);
                        break;
                    case "/":
                        stack.push(numTwo / numOne);
                        break;
                }
            }
            else 
                stack.push(Integer.parseInt(tokens[i]));
            i++;
        }
        return stack.peek();
    }
}