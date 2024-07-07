
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 시작지점을 옮겨가면서 모든 경우의 수 탐색
		// 점프 횟수 시도 당 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 블럭 개수
		int N = Integer.parseInt(st.nextToken());
		// 보폭
		int K = Integer.parseInt(st.nextToken());

		// 블럭간 거리
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] lenArr = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			lenArr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		// 시작 위치 바꿔가면서 탐색
		for (int i = 0; i < N - 1; i++) {
			int jumpCnt = 1;
			int sum = 1;
			pattern:
			for (int j = i; j < N - 1; j++) {
				// 다음 블럭이 보폭보다 작거나 같다면
				if (lenArr[j] <= K) {
					sum++;
				} else {
					if (jumpCnt == 1) {
						jumpCnt--; // 점프 시도
						sum++;						
					} else {
						// 이동거리 탐색 탈출
						break pattern;
					}
				}
			}
			if (max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);

	}
}
