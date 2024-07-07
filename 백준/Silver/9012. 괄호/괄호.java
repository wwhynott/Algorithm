import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		start:
		for (int i=0; i<T; i++) {
			// 여는 괄호 push 닫는 괄호 pop
			// stack 비어있는데 닫는 괄호 나오는 경우 바로 NO
			// 최종 스택이 비어있는 경우에만 VPS
			Stack<Character> stack = new Stack<>();
			
			String input = br.readLine();
			
			for (int j=0; j<input.length(); j++) {
				char c = input.charAt(j);
				
				if (c == '(') {
					stack.push(c);
				} else { // c == ')'
					if (!(stack.isEmpty())) {
						stack.pop();
					} else {
						// 비어있는데 닫는 괄호 나올 경우 바로 NO로 빠지도록
						sb.append("NO"+"\n");
						continue start;
					}
				}
			}
			
			if (stack.isEmpty()) {
				sb.append("YES"+"\n");
			} else {
				sb.append("NO"+"\n");
			}
		}
		System.out.println(sb);
	}
}