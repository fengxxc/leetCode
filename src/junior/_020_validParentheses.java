package junior;

import java.util.EmptyStackException;
import java.util.Stack;

public class _020_validParentheses {
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] cs = s.toCharArray();
        try {
			for (int i = 0; i < cs.length; i++) {
				char c = cs[i];
				if (c == '(' || c == '[' || c == '{') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.pop() != '(') 
						return false;
				} else if (c == ']') {
					if (stack.pop() != '[') 
						return false;
				} else if (c == '}') {
					if (stack.pop() != '{') 
						return false;
				}
			}
		} catch (EmptyStackException e) {
			return false;
		}
        if (!stack.isEmpty()) 
			return false;
        return true;
    }
	
	public static void main(String[] args) {
//		boolean valid = isValid("()");
//		System.out.println(valid); // true
//		boolean valid2 = isValid("()[]{}");
//		System.out.println(valid2); // true
//		boolean valid3 = isValid("(]");
//		System.out.println(valid3); // false
//		boolean valid4 = isValid("([)]");
//		System.out.println(valid4); // false
//		boolean valid5 = isValid("{[]}");
//		System.out.println(valid5); // true
//		boolean valid6 = isValid("eef32(qw[e]f)34{f}uuu{uh[uul]}j");
//		System.out.println(valid6);
		boolean valid7 = isValid("()[]{}");
		System.out.println(valid7);
		System.exit(0);
	}
}
