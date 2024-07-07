
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
	static int n;
	static Queue<Integer> input = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();
	static boolean flag = false; // 불가능한 경우 true
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		// 입력은 일단 저장해놓고 (큐?) 하나씩 빼면서 어떤 작업 수행해야 할지 결정

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			input.add(Integer.parseInt(br.readLine()));
		}
	
		int p = input.poll();
		// 가장 첫번째 수 만큼 일단 push
		for (int i=1; i<=p; i++) {
			stack.push(i);
			sb.append("+"+"\n");
		}
		int tmp = stack.pop();
		sb.append("-"+"\n");
		
		int save = p; // 스택에 어디까지 넣었다
		
		// 두번째 수부터는 input 큐가 빌때까지 반복
		while(!input.isEmpty()) {
			p = input.poll();
			if (tmp < p) { // 스택에 쌓인 수보다 크다?
				for (int i=save+1; i<=p; i++) {
					stack.push(i);
					sb.append("+"+"\n");
				}
				save = p;
				tmp = stack.pop();
				sb.append("-"+"\n");
			} else { // 스택에 쌓인 수보다 작다
				if (stack.peek() == p) { // 스택 맨 위 값이랑 같다? 
					tmp = stack.pop();
					sb.append("-"+"\n");
				} else {
					flag = true; // 불가능~
					break;
				}
			}
		}
		
		if (flag) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
		
	}
}
