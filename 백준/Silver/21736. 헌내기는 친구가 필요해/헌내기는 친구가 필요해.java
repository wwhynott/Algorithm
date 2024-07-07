
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static char[][] campus;
	static int cnt = 0; // 만날수 있는 사람의 수
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		campus = new char[N][M];
		visit = new boolean[N][M];
		
		for (int r=0; r<N; r++) {
			campus[r] = br.readLine().toCharArray();
		}
		
		// 도연이 위치 찾기
		int dyR = 0;
		int dyC = 0;
		label:
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (campus[r][c] == 'I') {
					dyR = r;
					dyC = c;
					break label;
				}
			}
		}
		
		dfs(dyR, dyC);
		
		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);			
		}
		
	}

	static void dfs(int r, int c) {
		// 더이상 이동 못하면 리턴
		if (visit[r][c]) {
			return;
		}
		if (campus[r][c] == 'P') { // 지금 위치에 사람이 있다?
			cnt++;
		}
		
		visit[r][c] = true;
		
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) { // 경계조건
				if (campus[nr][nc] != 'X') { // 벽이 아닐경우는 이동
					dfs(nr, nc);
				}
			}
		}
		
		
	}
}
