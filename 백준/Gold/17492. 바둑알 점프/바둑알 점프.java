
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr; // 바둑판 정보
	static int[] dr = { -1, 1, 0, 0, -1, 1, 1, -1 }; // 상 하 좌 우 우상 우하 좌하 좌상
	static int[] dc = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int badookal = 0; // 바둑알 개수
	static boolean flag = false; // 가능여부

	public static void main(String[] args) throws Exception {
		// 바둑알 하나에서 움직일 수 있는 방향으로 백트래킹 진행해보기?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		// 바둑판 정보 저장
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int input = Integer.parseInt(st.nextToken());
				arr[r][c] = input;
				if (input == 2) {
					badookal++; // 바둑알 개수 저장해두기
				}
			}
		}

		// 둘레는 모두 벽이다
		// 바둑알(==2)일 때 dfs 진행?
		label: for (int r = 1; r < N - 1; r++) {
			for (int c = 1; c < N - 1; c++) {
				if (arr[r][c] == 2) {
					dfs(r, c, badookal);
					if (flag)
						break label;
				}
			}
		}

		if (flag) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}

	}

	static void dfs(int r, int c, int cnt) {
		// 바둑알 개수가 하나 남았을 때 리턴~
		if (cnt == 1) {
			flag = true;
			return;
		}

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			int nnr = nr + dr[d];
			int nnc = nc + dc[d];

			// 둘레가 벽이라 nr의 경계조건은 필요 없음
			if (arr[nr][nc] == 2) { // 인접한 곳이 바둑알이고
				if (nnr >= 0 && nnr < N && nnc >= 0 && nnc < N) { // 점프할위치 경계조건
					if (arr[nnr][nnc] == 0) { // 점프할 곳이 빈칸이어야 함
						arr[r][c] = 0; // 원래 칸 지우고
						arr[nr][nc] = 0; // 사이에 있던 바둑알 지우고
						arr[nnr][nnc] = 2; // 점프~ 
						
						// 다시 바둑판을 돌면서 dfs 진행 
						for (int i=1; i<N-1; i++) {
							for (int j=1; j<N-1; j++) {
								if (arr[i][j] == 2) {
									dfs(i, j, cnt-1);
								}
							}
						}
						
						arr[r][c] = 2; // 방문 취소
						arr[nr][nc] = 2; // 방문 취소
						arr[nnr][nnc] = 0; // 방문 취소
					}
				}

			}
		}

	}
}
