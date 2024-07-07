
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 100*100 크기의 0 평면
		// 색종이가 덮인 영역은 1

		// 1이 있는 영역의 4방탐색 후
		// 0이 있다면 그 수만큼 길이 +1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 색종이 개수
		int T = Integer.parseInt(br.readLine());

		// 2차원 평면 배열
		int[][] arr = new int[100][100];

		// 평면에 색종이 얹기 (10*10 크기)
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 시작 행 좌표
			int sr = Integer.parseInt(st.nextToken());
			// 시작 열 좌표
			int sc = Integer.parseInt(st.nextToken());

			// 색종이 면적에 1 채우기
			for (int r = sr; r < sr + 10; r++) {
				for (int c = sc; c < sc + 10; c++) {
					arr[r][c] = 1;
				}
			}
		}

		// 1이 쓰여진 칸의 사방탐색
		int[] drArr = { -1, 1, 0, 0 }; // 상 하 좌 우
		int[] dcArr = { 0, 0, -1, 1 };

		// 길이
		int p = 0;

		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				// 1일때
				if (arr[r][c] == 1) {
					// 모서리에 있는 경우 사방탐색이 안되는 부분이 있지만(경계조건)
					// 둘레는 늘려줘야 한다
					// 꼭지점인 [0][0], [0][99], [99][0], [99][99] 는 p+=2
					if ((r==0 && c==0) || (r==99 && c==0) ||
							(r==0 && c==99) || (r==99 && c==99)) {
						p+=2;
					} else if (r==0 || c==0 || r==99 || c==99) {
						p++;
					}
					
					// 사방탐색
					for (int d = 0; d < 4; d++) {
						int nr = r+drArr[d];
						int nc = c+dcArr[d];
						
						// 경계조건
						if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100) {
							if (arr[r + drArr[d]][c + dcArr[d]] == 0) {
								p++;
							}
						}
						
					}
				}
				
				
			}
		}
		
		System.out.println(p);

	}
}
