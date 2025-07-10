package stack;

import java.util.*;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operands = new HashSet<>(List.of("+", "-", "*", "/"));
        for(String s : tokens) {
            if (operands.contains(s)) {
                int val2 = Integer.parseInt(stack.pop());
                int val1 = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+": {
                        stack.push(String.valueOf(val1 + val2));
                    }break;
                    case "-": {
                        stack.push(String.valueOf(val1 - val2));
                    }break;
                    case "*": {
                        stack.push(String.valueOf(val1 * val2));
                    }break;
                    case "/": {
                        stack.push(String.valueOf(val1 / val2));
                    }break;
                }
            }else {
                stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static void runTests() {
        ReversePolishNotation t = new ReversePolishNotation();


        String[][] inputs = {
                {"1","2","+","3","*","4","-"},
        };


        for (int i = 0; i < inputs.length; i++) {
            System.out.println(t.evalRPN(inputs[i]));
        }
    }
}
