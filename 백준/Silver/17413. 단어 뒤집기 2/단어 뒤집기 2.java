
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		// 스택에 단어 push, 공백 만나면 pop
		// < 만나면 > 가 나올때까지 sb에 쌓기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i) == '<') {
				// 뽑을 단어 있는지 먼저 확인
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				while (input.charAt(i) != '>') {
					sb.append(input.charAt(i));
					i++;
				}
				sb.append(input.charAt(i)); // '>'
			} else if (input.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				// 공백 추가
				sb.append(' ');
			} else {
				stack.push(input.charAt(i));
			}
		}
		
		// 마지막에 스택에 요소 남아있다면 비워준다
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
