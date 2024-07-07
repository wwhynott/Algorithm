
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 연산 개수
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (pq.size() > 0) {
					sb.append(pq.poll()+"\n");
				} else {
					sb.append(0+"\n");
				}
			} else { // 0이 아닌 자연수라면 x 입력
				pq.add(x);
			}
		}
		
		System.out.println(sb);
	}
}
