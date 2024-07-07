import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int max = 0;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<=100; i++) {
			visit = new boolean[N][N];
			int cnt = 0; // 구역의 개수
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (map[r][c] > i && !visit[r][c]) { // 아직 물에 잠기지 않았다면 ~ 
						dfs(r, c, i);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	static void dfs(int r, int c, int i) {
		// 더이상 갈곳이 없다~
		if (visit[r][c]) {
			return;
		}
		
		visit[r][c] = true;
		
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<N && nc>=0 && nc<N) {
				if (map[nr][nc] > i) {
					dfs(nr, nc, i);
				}
			}
			
		}
		
		
	}
}
