
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int v, dist;

		public Point(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
	}
	
	static int N, M;
	static List<Integer>[] connInfo;
	static int min = 987654321;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connInfo = new ArrayList[N+1]; // 노드는 1부터
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		visit = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			
			connInfo[x].add(y);
		}
		
		bfs();
		
		if (min == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(1, 0));
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			Point next = queue.poll();
			int nd = next.dist+1;
			
			for (int i : connInfo[next.v]) {
				if (!visit[i]) {
					queue.add(new Point(i, nd));
					visit[i] = true;
				}
			}
			
			if (next.v == N) {
				min = Math.min(min, next.dist);
				break;
			}
		}
		
		
		
	}
}
