package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> hiddenStack;

    public MinStack() {
        mainStack = new Stack<>();
        hiddenStack = new Stack<>();
    }

    public void push(int val) {
        if (hiddenStack.isEmpty()) {
            hiddenStack.push(val);
            mainStack.push(val);
            return;
        }
        int min = Math.min(hiddenStack.peek(), val);
        mainStack.push(val);
        hiddenStack.push(min);
    }

    public void pop() {
        mainStack.pop();
        hiddenStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return hiddenStack.peek();
    }

    public static void runTests() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.top());    // return 2
        System.out.println(minStack.getMin()); // return 1
    }
}
