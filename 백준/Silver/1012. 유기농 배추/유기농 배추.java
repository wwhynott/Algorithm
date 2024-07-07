
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 배추 좌표
	static class Baechoo {
		int r;
		int c;
		
		Baechoo() {	
		}
		
		Baechoo(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int M, N, K; // 배추밭 가로 세로 배추위치
	static int[][] map; // 배추밭
	static boolean[][] visit;
	static Baechoo[] baechooArr; // 배추 좌표 배열
	static int res; // 지렁이 개수
	static StringBuilder sb = new StringBuilder();
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		// 구역 개수 구하기 (구역 : 인접한 배추 덩어리)
		// 배추가 있는 지역 배열에 담아두고
		// 배열 돌면서 dfs 진행
		// 방문한적 없는 구역만 고고~
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 가로길이 (열)
			N = Integer.parseInt(st.nextToken()); // 세로길이 (행)
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			baechooArr = new Baechoo[K];
			res = 0;
			
			for (int i=0; i<K; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				
				// 좌표 행열 반대임,,
				int C = Integer.parseInt(st2.nextToken());				
				int R = Integer.parseInt(st2.nextToken());
				
				map[R][C] = 1; // 밭에 배추 심기
				baechooArr[i] = new Baechoo(R, C); // 배추 배열에도 저장
			}
			
			for (int i=0; i<K; i++) {
				int R = baechooArr[i].r;
				int C = baechooArr[i].c;
				if (!visit[R][C]) {
					dfs(R, C);
					res++;
				}
			}
			
			sb.append(res+"\n");
		}
		
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		// 더이상 갈곳이 없다~
		if (visit[r][c]) {
			return;
		}
		visit[r][c] = true; // 방문처리
		
		// 인접 배추로 이동
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr >= 0 && nr<N && nc >=0 && nc < M) { // 경계조건
				if (map[nr][nc] == 1) { // 배추?
					dfs(nr, nc);
				}
				
			}
		}
		
	}
}
