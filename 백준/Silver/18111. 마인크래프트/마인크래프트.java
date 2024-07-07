import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// 높이의 최소값부터 최대값까지 맞추는 모든 경우의 수를 탐색해서
		// 최소 시간을 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// 땅 높이 배열
		int[][] groundArr = new int[N][M];
		
		// 최대값 최소값
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int r=0; r<N; r++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				int h = Integer.parseInt(st2.nextToken());
				groundArr[r][c] = h;
				if (h > max) max = h;
				else if (h < min) min = h;
			}
		}
		
		int time = Integer.MAX_VALUE; // 최소 시간, (H*2)+L;
		int height = 0; // 최종 맞춰진 높이
		
		for (int h=min; h<=max; h++) {
			int H = 0; // 낮춰야 하는 높이
			int L = 0; // 높여야 하는 높이
			int inventory = B; // 인벤토리 고려
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (groundArr[r][c] > h) { // 제거
						H += groundArr[r][c]-h;
						inventory += groundArr[r][c]-h;
					} else { // 추가
						L += h-groundArr[r][c];
						inventory -= h-groundArr[r][c];
					}
				}
			}

			if ((inventory >= 0) && (((H*2)+L) <= time)) { // 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력해야 하는 조건 때문에 작거나 '같다'
				time = (H*2)+L;
				height = h;
			}
		}
		
		
		System.out.println(time+" "+height);

	}
}