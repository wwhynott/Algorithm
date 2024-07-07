import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer>[] connInfo;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static int max=0;
	static int min=987654321;
	static int[] cCntArr;
	
	public static void main(String[] args) throws Exception {
		// dfs는 시간초과,, bfs?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connInfo = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		cCntArr = new int[N+1];
				
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());
			
//			connInfo[B].add(A); // 방향 반대로 하면 더 조금 걸리나?
			connInfo[A].add(B); // 어떤 컴퓨터에게 해킹당할 수 있는지
			
		}
		
		for (int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			bfs(i);
		}
		
		for (int i=1; i<=N; i++) {
			if (max < cCntArr[i]) {
				max = cCntArr[i];
			}
		}
		
		for (int i=1; i<=N; i++) {
			if (cCntArr[i] == max) {
				sb.append(i+" ");
			}
		}
		
		System.out.println(sb);
	}

	static void bfs(int c) {
		// 각 컴퓨터에서 bfs 진행해서 방문하는 컴퓨터의 최대값 구하고
		// max 값 없데이트 
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(c);
		visit[c] = true;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();

			for (int i : connInfo[next]) {
				if (!visit[i]) {
					queue.add(i);
					visit[i] = true;
					cCntArr[i]++; // 배열요소를 직접 ++ 하는게 더 시간이 덜걸린다 4%까지는 감....
				}
			}
		}
	}
}
