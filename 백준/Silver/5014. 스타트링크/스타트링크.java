import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int F, S, G, U, D; // 건물 층수, 시작위치, 목적지, 위로n층, 아래로n층
	static int[] slArr; // 건물 배열
	static boolean[] visit;
	static boolean flag; // G층 도착 여부
	static int res = 0; // 버튼 수 최소값
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		slArr = new int[F+1]; // 건물은 1층부터
		visit = new boolean[F+1];
		flag = false;
		
		bfs();
		
		if (flag) {
			System.out.println(res);
		} else {
			System.out.println("use the stairs");
		}
		
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {S, 0});
		visit[S] = true;
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int floor = next[0];
			int cnt = next[1];
			
			if (floor == G) { // 목적지 도착
				flag = true;
				res = cnt;
				break;
			}
			
			// 경계조건 위아래 따로?
			if ((floor + U <= F) && (!visit[floor+U])) {
				queue.add(new int[] {floor+U, cnt+1});
				visit[floor+U] = true;
			}
			
			if ((floor - D >= 1) && (!visit[floor-D])) {
				queue.add(new int[] {floor-D, cnt+1});
				visit[floor-D] = true;
			}

		}
		
	}
}
