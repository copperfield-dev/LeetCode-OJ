class MinStack {
    public void push(int x) {
        dataStack.push(x);
        if (minStack.empty() || x < minStack.peek())
            minStack.push(x);
        else 
            minStack.push(minStack.peek());
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        int value = dataStack.peek();
        return value;
    }

    public int getMin() {
        int min = minStack.peek();
        return min;
    }

    private Stack<Integer> minStack = new Stack<Integer>();

    private Stack<Integer> dataStack = new Stack<Integer>();
}
