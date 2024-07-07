
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cnt; // 노드, 간선, 연결 요소 개수
	static List<Integer>[] connInfo;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		connInfo = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		visit = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			connInfo[a].add(b);
			connInfo[b].add(a);
		}
		
		for (int i=1; i<=N; i++) {
			if (!visit[i]) { // 방문 안했을때만
				getCC(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

	static void getCC(int idx) {
		if (visit[idx]) {
			return;
		}
		visit[idx] = true; // 방문처리
		
		for (int i : connInfo[idx]) {
			getCC(i);
		}
	}
}
