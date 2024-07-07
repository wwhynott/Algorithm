import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사람 수 
		int N = Integer.parseInt(st.nextToken());
		// 큐에 사람 배치
		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		// 제거되는 순서
		int K = Integer.parseInt(st.nextToken());
		
		// 제거되는 사람 담을 큐
		Queue<Integer> rmQueue = new LinkedList<>();
		
		// queue를 돌면서 제거되는 사람 rmQueue으로 옮기기
		// 제거되는 사람 수 = 원래 사람수 될때까지
		while (rmQueue.size() != N) {
			// K-1번은 꺼내서 원래 큐에 다시 넣고
			for (int i=0; i<K-1; i++) {
				int tmp = queue.poll();
				queue.offer(tmp);
			}
			// K번째 사람은 꺼내서 rmQueue로 옮기기
			int kill = queue.poll();
			rmQueue.offer(kill);
		}
		
		// 출력 스트링
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		for (int i=0; i<N; i++) {
			if (i != N-1) {
				sb.append(rmQueue.poll()+", ");
			} else {
				sb.append(rmQueue.poll());
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}
}