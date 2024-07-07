
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int r, c, dist;

		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	static int dr[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int dc[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int N, M; // map 크기, 말 개수
	static Point knight; // 나이트 좌표
	static Point[] malArr; // 말 좌표 저장 배열
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		malArr = new Point[M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		knight = new Point(Integer.parseInt(st2.nextToken())-1,Integer.parseInt(st2.nextToken())-1, 0);
		
		for (int i=0; i<M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st3.nextToken());
			int c = Integer.parseInt(st3.nextToken());
			
			malArr[i] = new Point(r-1, c-1, 987654321);
		}
		

		visit = new boolean[N][N];
		bfs();
		
		for (int i=0; i<M; i++) {
			sb.append(malArr[i].dist+" ");
		}
		
		System.out.println(sb);
		
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(knight);
		visit[knight.r][knight.c] = true;
		
		while(!queue.isEmpty()) {
			Point next = queue.poll();
			int nd = next.dist+1;
			
			for (int d=0; d<8; d++) {
				int nr = next.r+dr[d];
				int nc = next.c+dc[d];
				
				if (nr >= 0 && nr<N && nc>=0 && nc<N) {
					if (!visit[nr][nc]) {
						
						for (Point p : malArr) {
							if (nr == p.r && nc == p.c) {
								p.dist = Math.min(p.dist, nd);
								continue;
							}
						}
						
						queue.add(new Point(nr, nc, nd));
						visit[nr][nc] = true;
					}
				}
			}

			
		}

	}
}
