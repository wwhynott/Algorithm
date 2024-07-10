
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int w, h; // 지도 너비, 높이
	static int[][] map;
	static boolean[][] visit;
	static int res; // 섬 개수
	
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
	
	public static void main(String[] args) throws Exception {
		// 1 땅 0 바다
		// 8방탐색 dfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0) {
				break;
			}
			map = new int[h][w];
			visit = new boolean[h][w];
			res = 0;
			
			// map 입력
			for (int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r=0; r<h; r++) {
				for (int c=0; c<w; c++) {
					if (map[r][c] == 1 && !visit[r][c]) {
						dfs(r, c);
						res++;
					}
				}
			}
			
			sb.append(res+"\n");
		}
		System.out.println(sb);
		
	}

	static void dfs(int r, int c) {
		visit[r][c] = true;
		
		for (int d=0; d<8; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<h && nc>=0 && nc<w && map[nr][nc]==1 && !visit[nr][nc]) {
				dfs(nr, nc);
			}
		}
		
	}
}
