import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		// 내림차순정렬
		// 우선순위 큐~
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		String input = br.readLine();
		
		for (int i=0; i<input.length(); i++) {
			pq.offer(input.charAt(i)-'0');
		}
		
		while (!pq.isEmpty()) {
			System.out.print(pq.poll());
		}
	}
}