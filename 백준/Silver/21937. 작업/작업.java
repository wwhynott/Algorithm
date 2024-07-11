
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M; // 작업 개수, 작업 순서 정보 개수
	static List<Integer>[] connInfo;
	static boolean[] visit;
	static int X;
	static int res = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connInfo = new List[N+1];
		visit = new boolean[N+1];
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			connInfo[b].add(a);
		}
		
		X = Integer.parseInt(br.readLine());
		dfs(X);
		
		System.out.println(res);
	}

	static void dfs(int n) {
		if (visit[n]) {
			return;
		}
		visit[n] = true;
		
		for (int a : connInfo[n]) {
			if (!visit[a]) {
				dfs(a);				
				res++;
			}
		}
	}
}
