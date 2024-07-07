
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, size;
	static int[][] map;
	static boolean[][] visit;
	static int max = 0;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		// 상하좌우로 인접한 음식물 덩어리 중 가장 큰 덩어리 크기 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
        size = 0;
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r-1][c-1] = 1;
		}
		
		// map 돌면서 음쓰일때 dfs
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (map[r][c] == 1 && !visit[r][c]) {
					dfs(r, c);
					
					max = Math.max(size, max);
					size = 0; // 음쓰 사이즈 초기화
				}
			}
		}
		
		System.out.println(max);
	}

	static void dfs(int r, int c) {
		if (visit[r][c]) {
			return;
		}
		
		visit[r][c] = true;
		size++;
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==1) {
				dfs(nr, nc);
			}
		}
		
		
	}
}
