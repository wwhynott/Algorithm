import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드 개수
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> card = new LinkedList<>();
		
		// 큐 초기설정
		for (int i=1; i<=N; i++) {
			card.offer(i);
		}
		
		// 한장 남을때까지 반복 : 한 장은 버리고 한 장은 꺼내서 맨 뒤로 넣기 
		while (card.size() != 1) {
			card.poll();
			int mv = card.poll();
			card.offer(mv);
		}
		
		System.out.println(card.peek());
	}
}