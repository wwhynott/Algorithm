
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;
	int dist;

	public Point(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
}

public class Main {

	static int n, m; // 지도 크기
	static int R, C; // 목표지점 좌표
	static int[][] map, resmap; // 원본 지도, 결과 지도
	static Queue<Point> queue;
	static int dist = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		// 목표지점에서 출발해서 각 지점까지의 거리를 출력하자~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		resmap = new int[n][m];
		// 도달할 수 없는 위치 표현 위해 resmap 요소를 모두 -1로 업데이트
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				resmap[r][c] = -1;
			}
		}

		queue = new LinkedList<>();
		visit = new boolean[n][m];

		for (int r = 0; r < n; r++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st2.nextToken());
			}
		}

		// 갈 수 없는 땅 표시
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (map[r][c] == 0) {
					resmap[r][c] = 0;
				}
			}
		}

		// 목표지점 찾기
		label: for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (map[r][c] == 2) {
					R = r;
					C = c;
					break label;
				}
			}
		}

		bfs(R, C);

		// 결과 출력
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				sb.append(resmap[r][c] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	static void bfs(int r, int c) {
		visit[r][c] = true;
		Point p = new Point(r, c, dist);
		queue.add(p);

		while (!queue.isEmpty()) {
			Point next = queue.poll();
			resmap[next.r][next.c] = next.dist; // 결과 맵에 dist 입력

			dist = next.dist + 1;
			for (int d = 0; d < 4; d++) {
				int nr = next.r + dr[d];
				int nc = next.c + dc[d];

				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc] && map[nr][nc] != 0) {
					Point p2 = new Point(nr, nc, dist);
					queue.add(p2);
					visit[nr][nc] = true;
				}
			}

		}

	}
}
