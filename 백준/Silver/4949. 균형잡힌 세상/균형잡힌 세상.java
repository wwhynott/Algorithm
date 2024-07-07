
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		// 여는 괄호들은 무조건 스택에 쌓고
		// 닫는 괄호들은 스택의 맨 위에 있는 괄호와 짝을 이뤄야만 균형잡힌 세상~
		// 괄호가 하나도 없어도 균형잡힌 문자열 => 스택이 비어있으면 균형으로 생각
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		sentence:
		while (true) {
			String input = br.readLine();
			if (input.equals(".")) {
				break sentence;
			}
			
			// 사용할 스택
			Stack<Character> stack = new Stack<>();
			
			for (int i=0; i<input.length(); i++) {
				if (input.charAt(i) == '(' || input.charAt(i) == '[') {
					stack.push(input.charAt(i));
				} else if (input.charAt(i) == ')') {
					if (stack.isEmpty()) {
						sb.append("no\n");
						continue sentence;
					} else {
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							sb.append("no\n");
							continue sentence;
						}
					}
				} else if (input.charAt(i) == ']') {
					if (stack.isEmpty()) {
						sb.append("no\n");
						continue sentence;
					} else {
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							sb.append("no\n");
							continue sentence;
						}
					}
				}
			}
			
			if (stack.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		
		System.out.println(sb);
	}
}
