import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 명령의 수

		// 사용할 deque 선언
		Deque<Integer> deq = new ArrayDeque<>();

		// 출력 String 선언
		StringBuilder sb = new StringBuilder();

		// 명령의 수 만큼 for
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken()); // case 받기 
			
			switch (c) {
				case 1:
					int X1 = Integer.parseInt(st.nextToken());
					deq.offerFirst(X1);
					break;
				case 2:
					int X2 = Integer.parseInt(st.nextToken());
					deq.offerLast(X2);
					break;
				case 3:
					if (deq.size() == 0) {
						sb.append(-1+"\n");
					} else {
						sb.append(deq.pollFirst()+"\n");
					}
					break;
				case 4:
					if (deq.size() == 0) {
						sb.append(-1+"\n");
					} else {
						sb.append(deq.pollLast()+"\n");
					}
					break;
				case 5:
					sb.append(deq.size()+"\n");
					break;
				case 6:
					if (deq.size() == 0) {
						sb.append(1+"\n");
					} else {
						sb.append(0+"\n");
					}
					break;
				case 7:
					if (deq.size() == 0) {
						sb.append(-1+"\n");
					} else {
						sb.append(deq.peekFirst()+"\n");
					}
					break;
				case 8:
					if (deq.size() == 0) {
						sb.append(-1+"\n");
					} else {
						sb.append(deq.peekLast()+"\n");
					}
					break;

			}
		}
		System.out.println(sb);
	}
}