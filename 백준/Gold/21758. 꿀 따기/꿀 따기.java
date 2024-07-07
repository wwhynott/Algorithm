
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, max;
	static int[] arr, dp;
	
	public static void main(String[] args) throws Exception {
		// 벌통 위치 옮겨가면서 벌 출발위치 2개 고르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		max = 0;
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = input;
			if (i == 0) {
				dp[0] = input;
			}
			if (i > 0) {
				dp[i] = dp[i-1]+input;
			}
		}
		
		// 벌통 오른쪽
		// (dp[b2-1] - dp[0]) + (dp[N-1] - dp[b2])*2
		for (int i=1; i<N-1; i++) { // i : 두번째 벌 idx
			int honey = (dp[i-1]-dp[0])+(2*(dp[N-1]-dp[i]));
			max = Math.max(max, honey);
		}
		
		// 벌통 왼쪽
		// Math.abs(dp[b2-1] - dp[0]) + Math.abs((dp[N-1] - dp[b2])*2)
		for (int i=N-2; i>=1; i--) {
			int honey = 2*(dp[i-1])+(dp[N-2]-dp[i]);
			max = Math.max(max, honey);
		}
		
		// 벌통 가운데
		// 꿀벌 양끝에서 출발
		// (dp[N-1]-dp[i])+(dp[i-1]-dp[0])
		for (int i=1; i<N-1; i++) { // i : 벌통 idx
			int honey = (dp[i]-dp[0])+(dp[N-2]-dp[i-1]);
			max = Math.max(max, honey);
		}
		
		
		System.out.println(max);

	}
}
