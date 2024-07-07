
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N; // 세로, 가로 크기
	static int[][] map; 
	static int[][] dp;
	static int cnt = 0; // 경로 개수
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int r=0; r<M; r++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st2.nextToken());
			}
		}
		
		for (int r=0; r<M; r++) {
			Arrays.fill(dp[r], -1);
		}
		
		cnt = dfs(0, 0, map[0][0]);
		
		System.out.println(cnt);
		
	}

	// r,c : 좌표 / h : 높이
	static int dfs(int r, int c, int h) {
		// 이미 방문한 적이 있다면 저장된 경우의 수 반환
		if (dp[r][c] != -1) {
			return dp[r][c];
		}
		
		// 도착~
		if (r == M-1 && c == N-1) {
			return 1; // 한개의 경로 찾음
		}
		
		dp[r][c] = 0; // 현재 위치에서 목적지까지 경로 개수
		
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<M && nc>=0 && nc<N) {
				if (h > map[nr][nc]) {
					dp[r][c] += dfs(nr, nc, map[nr][nc]);
				}
			}
		}
		
		return dp[r][c];
	}
}
