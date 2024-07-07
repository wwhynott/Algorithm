import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 우선순위 큐 (내림차순) 
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 표 크기
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		// N-1개 만큼 버리고
		for (int i=0; i<N-1; i++) {
			pq.poll();
		}
		
		// N번째 큰 수 출력
		System.out.println(pq.poll());
	}
}