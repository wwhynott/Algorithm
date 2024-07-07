
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Tomato {
		int r, c, d; // 가로, 세로, 몇일째

		public Tomato(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static int M, N; // map[M][N]
	static int[][] map;
	static boolean[][] visit;
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
		map = new int[N][M];
		visit = new boolean[N][M];
		
		queue = new ArrayDeque<>();
		
		for (int r=0; r<N; r++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				int t = Integer.parseInt(st2.nextToken());
				map[r][c] = t;
				if (t == 1) {
					queue.add(new Tomato(r, c, 0));
					visit[r][c] = true;
				}
			}
		}
		
		// bfs
		while (!queue.isEmpty()) {
			Tomato next = queue.poll();
			int r = next.r;
			int c = next.c;
			int day = next.d+1;
			
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if (nr>=0 && nr<N && nc>=0 && nc<M) {
					if (!visit[nr][nc] && map[nr][nc] == 0) {
						visit[nr][nc] = true;
						map[nr][nc] = 1;
						queue.add(new Tomato(nr, nc, day));
					}
				}
			}
			
			res = day-1;
		}
		
		// 안익은 토마토가 map에 남아있다면 flag = false;
		label:
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (map[r][c] == 0) {
					flag = false;
					break label;
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
