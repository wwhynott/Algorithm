
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp[1] = 0;
		if (N >= 2) {
			dp[2] = 1;			
		}
		if (N >= 3) {
			dp[3] = 1;			
		}
		
		for (int i=4; i<=N; i++) {
			int min = 987654321;
			
			/*
			 * 
			 * n % 3 == 0 ?
			 * -> dp[n] = dp[n/3]+1
			 * n % 2 == 0 ?
			 * -> dp[n] = dp[n/2]+1
			 * 나머지?
			 * -> dp[n] = dp[n-1]+1
			 * 
			 * dp[3] = 1
			 * dp[2] = 1
			 * dp[1] = 0
			 *  
			 */
			
			min = Math.min(min, dp[i-1]+1);
			if (i%3 == 0) {
				min = Math.min(min, dp[i/3]+1);
			}
			if (i%2 == 0) {
				min = Math.min(min, dp[i/2]+1);
			}
			
			dp[i] = min;
			
		}
		
		System.out.println(dp[N]);
		
	}
}
