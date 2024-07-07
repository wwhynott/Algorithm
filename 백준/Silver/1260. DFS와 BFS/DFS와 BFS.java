
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V; // 노드, 간선, 탐색 시작 노드번호
	static List<Integer>[] connInfo;
	static boolean[] visit;
	static Queue<Integer> queue;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		connInfo = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		visit = new boolean[N+1];
		queue = new LinkedList<>();
		
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			connInfo[a].add(b);
			connInfo[b].add(a);
		}
		
		// 정점 번호 작은것 부터 탐색하기 위해 정렬
		for (int i=1; i<=N; i++) {
			Collections.sort(connInfo[i]);
		}
		
		dfs(V);
		sb.append("\n");
		
		visit = new boolean[N+1]; // 방문처리 초기화

		bfs(V);
		
		System.out.println(sb);
	}

	static void dfs(int idx) {
		// 모두 방문했다면 return
		if (visit[idx]) {
			return;
		}
		visit[idx] = true; // 방문처리
		sb.append(idx+" ");
		
		for (int i : connInfo[idx]) {
			dfs(i);
		}
	}
	
	
	static void bfs(int idx) {
		visit[idx] = true; // 방문처리
		queue.add(idx);
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			sb.append(next+" ");
			for (int i : connInfo[next]) {
				if (!visit[i]) { // 아직 방문하지 않았다면
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
