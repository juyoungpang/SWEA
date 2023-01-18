package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1218_stack {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			
			System.out.printf("#%d ", test_case);
			
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			boolean isComplete = true;
			for(int i=0;i<str.length();i++) {
				if(!isComplete) break;
				char c = str.charAt(i);
				switch (c) {
				case ')':
					if(stack.peek()=='(') stack.pop();
					else isComplete=false;
					break;
				case '}':
					if(stack.peek()=='{') stack.pop();
					else isComplete=false;
					break;
				case ']':
					if(stack.peek()=='[') stack.pop();
					else isComplete=false;
					break;
				case '>':
					if(stack.peek()=='<') stack.pop();
					else isComplete=false;
					break;

				default:
					stack.add(c);
					break;
				}
			}
			
			System.out.println(isComplete&&stack.isEmpty()?1:0);
		}
	}
}