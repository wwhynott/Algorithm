import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 색종이 개수
		int T = Integer.parseInt(br.readLine());

		// 도화지 크기
		int[][] arr = new int[100][100];

		// 색종이를 붙일때 마다 평면의 숫자를 1로 바꾼다

		// 평면에 색종이 얹기
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 시작 행 좌표
			int sr = Integer.parseInt(st.nextToken());
			// 시작 열 좌표
			int sc = Integer.parseInt(st.nextToken());
			// 끝 행 좌표
			int er = sr + 9; // 9만큼만 더해야 길이는 10이 된다
			// 끝 열 좌표
			int ec = sc + 9;

			// 색종이 면적 만큼 순서에 맞는 숫자로 바꾸기
			for (int r = sr; r <= er; r++) {
				for (int c = sc; c <= ec; c++) {
					arr[r][c] = 1;
				}
			}
		}

		// 최종 평면에서 1의 개수(= 검은색 영역) 구하기
		int area = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (arr[r][c] == 1) {
					area++;
				}
			}
		}
		System.out.println(area);
	}
}