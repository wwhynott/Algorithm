
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Tomato {
		int r, c, h, d; // 가로, 세로, 높이, 몇일째

		public Tomato(int r, int c, int h, int d) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.d = d;
		}
	}
	
	static int M, N, H; // map[N][M][H];
	static int[][][] map;
	static boolean[][][] visit;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1}; 
	static int res;
	static boolean flag = true;
	
	static Queue<Tomato> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		visit = new boolean[N][M][H];
		
		queue = new ArrayDeque<>();
		
		for (int h=0; h<H; h++) {
			for (int r=0; r<N; r++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int c=0; c<M; c++) {
					int t = Integer.parseInt(st2.nextToken());
					map[r][c][h] = t;
					if (t == 1) {
						queue.add(new Tomato(r, c, h, 0));
						visit[r][c][h] = true;
					}
				}
			}
			
		}
		
		// bfs
		while (!queue.isEmpty()) {
			Tomato next = queue.poll();
			int r = next.r;
			int c = next.c;
			int h = next.h;
			int day = next.d+1;
			
			// 지금 높이
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
							
				if (nr>=0 && nr<N && nc>=0 && nc<M) {
					if (!visit[nr][nc][h] && map[nr][nc][h] == 0) {
						visit[nr][nc][h] = true;
						map[nr][nc][h] = 1;
						queue.add(new Tomato(nr, nc, h, day));
					}
				}				
			}
			
			int nUp = h+1;
			int nDown = h-1;
			
			// 위
			if (nUp < H && !visit[r][c][nUp] && map[r][c][nUp] == 0) {
				visit[r][c][nUp] = true;
				map[r][c][nUp] = 1;
				queue.add(new Tomato(r, c, nUp, day));
			}
			
			// 아래
			if (nDown >= 0 && !visit[r][c][nDown] && map[r][c][nDown] == 0) {
				visit[r][c][nDown] = true;
				map[r][c][nDown] = 1;
				queue.add(new Tomato(r, c, nDown, day));
			}
			
			res = day-1;
		}
		
		// 안익은 토마토가 map에 남아있다면 flag = false;
		label:
		for (int h=0; h<H; h++) {
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (map[r][c][h] == 0) {
						flag = false;
						break label;
					}
				}
			}
		}
		
		if (flag) {
			System.out.println(res);			
		} else {
			System.out.println(-1);
		}
		
		
	}
}
