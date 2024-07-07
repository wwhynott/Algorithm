import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 명령의 수 입력
		
		// 사용할 stack 선언
		Stack<Integer> res = new Stack<>();
		
		// 출력 String 선언
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken()); // case 받기 
			
			switch (c) {
				case 1: // 입력할 정수 X 받기
					int X = Integer.parseInt(st.nextToken());
					res.push(X);
					break;
				case 2:
					if (res.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(res.pop()+"\n"); 
					}
					break;
				case 3:
					sb.append(res.size()+"\n");
					break;
				case 4:
					if (res.isEmpty()) {
						sb.append(1+"\n");
					} else {
						sb.append(0+"\n");
					}
					break;
				case 5:
					if (res.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(res.peek()+"\n");
					}
					break;
			}
			
		}
		
		System.out.println(sb);
	}
}