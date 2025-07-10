package stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            switch (currentChar) {
                case '(', '[', '{': {
                    stack.push(currentChar);
                }break;
                case ')', ']', '}': {
                    if (stack.isEmpty()){
                        return false;
                    }
                    char lastOpenBracket = stack.pop();

                    if (lastOpenBracket == '(' && currentChar != ')') {
                        return false;
                    }
                    if (lastOpenBracket == '{' && currentChar != '}') {
                        return false;
                    }
                    if (lastOpenBracket == '[' && currentChar != ']') {
                        return false;
                    }
                }

            }
        }

        return stack.empty();
    }

    public static void runTests() {
        ValidParentheses t = new ValidParentheses();


        String[][] inputs = {
                {"[]"},
                {"([{}])"},
                {"[(])"}
        };


        for (int i = 0; i < inputs.length; i++) {
            System.out.println(t.isValid(inputs[i][0]));
        }
    }
}
