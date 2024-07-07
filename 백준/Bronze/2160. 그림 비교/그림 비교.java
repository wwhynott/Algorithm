import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 2차원 배열 여러개를 보관할 배열 ........ -> 3차원 배열..?
		char[][][] arr = new char[N][5][7];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = br.readLine().toCharArray();
			}
		}

		// 두 배열씩 비교해서 다른 칸의 개수를 배열에 저장
		// 경우의 수 nC2
		int diffArrLength = (N * (N - 1)) / 2;
		int[] diffArr = new int[diffArrLength];

		// 어떤 배열끼리 비교한건지 저장할 배열 추가......
		String[] whichArr = new String[diffArrLength];


		int idx = 0;

		// 비교할 배열 1
		for (int j = 0; j < N; j++) {
			// 비교할 배열 2
			for (int k = j + 1; k < N; k++) {
				int diffCnt = 0;
				// 행 비교
				for (int r = 0; r < 5; r++) {
					// 열 비교
					for (int c = 0; c < 7; c++) {
						if (arr[j][r][c] != arr[k][r][c]) {
							diffCnt++;
						}
					}
				}
				whichArr[idx] = (j + 1) + " " + (k + 1);
				diffArr[idx] = diffCnt;
				idx++;
			}
		}

		// diffArr에서 min, minIdx 찾기
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < diffArrLength; i++) {
			if (min > diffArr[i]) {
				min = diffArr[i];
				minIdx = i;
			}
		}

		// 인덱스 넘버와 비교 그림 매칭 어떻게?...........
		// -> 어떤 배열끼리 비교중인지 배열에 저장 (idx 맞춰서)
		System.out.println(whichArr[minIdx]);
	}

}