
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int num;
		int time;

		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	static final int INF = 987654321;
	static int N, M, X; // 마을(학생) 수, 도로 개수, 파티 장소
	static List<Node>[] connInfo;
	static int[] dist;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		// 다익스트라
		// 한 명당 다익스트라 2번 (올때 갈때)
		// 도로는 단방향이지만....... 각 도시를 잇는 도로가 2개일수 있으니까 visit 배열 사용 ?

		// 한 명의 소요시간 구할때마다 dist 배열 업데이트?

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		connInfo = new ArrayList[N + 1]; // 마을번호 1부터
		for (int i = 0; i < N + 1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		dist = new int[N + 1];

		// 도로
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st2.nextToken()); // 시작점
			int B = Integer.parseInt(st2.nextToken()); // 끝점
			int T = Integer.parseInt(st2.nextToken()); // 소요시간

			connInfo[A].add(new Node(B, T));
		}

		// 각 마을에서 X로 오고가는데 걸리는 시간 구하기
		for (int i = 1; i <= N; i++) {
			int res = 0;

			// dist 초기화 시켜주고
			Arrays.fill(dist, INF);
			dijkstra(i); // 갈때
			res += dist[X];

			// dist 초기화 시켜주고
			Arrays.fill(dist, INF);
			dijkstra(X); // 올때
			res += dist[i];

			max = Math.max(max, res);
		}

		System.out.println(max);

	}

	static void dijkstra(int i) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		dist[i] = 0; // 시작 노드까지의 거리는 0으로 초기화
		visited[i] = true;

		pq.add(new Node(i, 0));

		while (!pq.isEmpty()) {
			Node next = pq.poll();

			int nNum = next.num;

			for (Node n : connInfo[nNum]) {
				if (!visited[n.num] || dist[n.num] > dist[nNum] + n.time) {
					visited[n.num] = true;
					dist[n.num] = dist[nNum] + n.time;
					pq.add(new Node(n.num, dist[n.num]));
				}
			}

		}

	}
}
