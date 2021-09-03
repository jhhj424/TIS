package leetcode;

import java.util.Stack;

public class _0020ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _0020ValidParentheses vp = new _0020ValidParentheses();

        System.out.println(vp.isValid("["));
        System.out.println(vp.isValid("]"));
        System.out.println(vp.isValid("[]"));
    }
}
