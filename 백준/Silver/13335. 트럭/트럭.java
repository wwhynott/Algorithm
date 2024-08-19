
import java.io.*;
import java.util.*;

public class Main {

	static int n, w, L, weight, time;
	static Queue<Integer> trucks, bridge;

	public static void main(String[] args) throws Exception {
		// 다리 : 큐를 사용해서 표현
		// 큐의 최대 사이즈 : w
		// 큐에 들어갈 수 있는 차의 최대 무게 : L

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		trucks = new LinkedList<>();
		bridge = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));			
		}

		// 다리위에 올라간 차들의 무게
		weight = 0;
		// 모든 트럭이 다리를 건너는데 걸리는 시간
		time = 0;

		// 다리에 0 무게의 트럭을 w개 올린다 (항상 w개가 올라가있도록!)
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}

		// bridge가 빌때까지 반복
		while (!bridge.isEmpty()) {
			time++;
			
			// 맨 앞 트럭 내린다
			weight -= bridge.poll();
			
			// 트럭이 남았다면
			if (!trucks.isEmpty()) {
				// 이미 올라간 트럭 무게 + 이번에 올릴 트럭 무게 <= L 이면
				if (weight + trucks.peek() <= L) {
					// 새 트럭 다리에 올린다!
					weight += trucks.peek();
					bridge.add(trucks.poll());
				} else { // 무게 넘친다?
					bridge.add(0); // 무게 0 트럭 올린다
				}
			}
		}
		System.out.println(time);
	}
}
