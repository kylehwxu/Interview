package validp;

import java.util.Stack;

public class Validp {
	public static boolean solution(String line) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < line.length(); i++) {
			if(stack.empty()) {
				stack.push(line.charAt(i));
			} else if ((stack.peek() == '(' && line.charAt(i) == ')') || (stack.peek() == '[' && line.charAt(i) == ']') || (stack.peek() == '{' && line.charAt(i) == '}')) {
				stack.pop();
			} else {
				stack.push(line.charAt(i));
			}
		}
		if (stack.empty()) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("(({{))}}(({{}}))"));
	}

}
