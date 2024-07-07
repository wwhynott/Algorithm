import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		
		// stack이 비어있을 때 닫힌 괄호가 나오는 횟수 만큼(pop 시도) 
		// 여는 괄호 추가
		
		// 필요한 괄호 개수 (결과) 
		int res = 0;
		// 여는 괄호 개수
		int O = 0;
		// 닫는 괄호 개수
		int C = 0;
		
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(') {
				stack.push(c);
				O++;
			} else { // 닫는 괄호
				C++;
				if (stack.isEmpty()) { // 비어있다?
					res++; // 필요한 여는 괄호 1개 추가
					O++;
				} else {
					stack.pop();
				}
			}
		}
		
		if (O == C) { // 괄호 짝 맞는다?
			System.out.println(res);
		} else { // 짝 안맞는다 -> 여는 괄호 개수와 닫는 괄호 개수 차이 만큼 더
			System.out.println(res + Math.abs(O-C)); 
		}
		
	}
}