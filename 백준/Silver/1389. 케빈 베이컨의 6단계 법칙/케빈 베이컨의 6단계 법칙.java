
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer>[] connInfo; // 친구 연결정보
	static boolean[] visit;
	static int kb, res;
	static int[] kbArr;
	static int min = 987654321;
	
	public static void main(String[] args) throws Exception {
		// 각 노드를 시작으로 bfs 돌면서 다른 노드 방문할때마다
		// 너비 더하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connInfo = new ArrayList[N+1]; // 노드번호 1번부터
		for (int i=0; i<=N; i++) {
			connInfo[i] = new ArrayList<>();
		}
		kbArr = new int[N+1];
		
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			connInfo[a].add(b);
			connInfo[b].add(a);
		}
		
		for (int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			kb = 0;
			bfs(i);
			kbArr[i] = kb;
			min = Math.min(min, kb);
		}
		
		for (int i=N; i>=1; i--) {
			if (kbArr[i] == min) {
				res = i;
			}
		}
		
		System.out.println(res);
		
	}

	static void bfs(int node) {
		Queue<int[]> queue = new LinkedList<>();
		visit[node] = true;
		int dist = 0;
		queue.add(new int[]{node, dist});
		
		while(!queue.isEmpty()) {
			int[] next = queue.poll();
			kb += next[1];
			dist = next[1]+1;
			
			for (int i : connInfo[next[0]]) {
				if (!visit[i]) {
					visit[i] = true;
					queue.add(new int[] {i, dist});
				}
			}
		}
	}
}
