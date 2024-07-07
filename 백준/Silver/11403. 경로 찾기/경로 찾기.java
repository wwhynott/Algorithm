
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, circle;
	static List<Integer>[] connInfo;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		connInfo = new ArrayList[N+1]; // 정점 1부터 시작
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		
		// 연결
		for (int r=1; r<=N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=1; c<=N; c++) {
				int conn = Integer.parseInt(st.nextToken());
				if (r != c && conn == 1) {
					connInfo[r].add(c);
				}
			}
		}
		
		// i,i 일때도 1을 만족하려면 나한테 되돌아 올 수 있는 경로 있어야함
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				visit = new boolean[N+1];
				flag = false;
				dfs(i, j);
				
				if (flag) {
					sb.append(1+" ");
				} else {
					sb.append(0+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}


	static void dfs(int i, int j) {
		// i부터 출발해서 j까지 닿는다면 리턴
        // 방문처리 잘~ 해줘서 원형인지도 확인하자
		if (i == j && visit[i]) {
			flag = true;
		}
		
		for (int v : connInfo[i]) {
			if (!visit[v]) {
				visit[v] = true;
				dfs(v, j);	
			}
		}
		
	}
}
