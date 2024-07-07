
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// dp 앞에서 부터 해보기~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+2];
		
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<=N; i++) {
			// 이전 날짜의 상담료가 현재 날짜의 상담료보다 클 경우 업데이트 
			dp[i] = Math.max(dp[i-1], dp[i]);
			
			// Ti일 후 dp 구하기
			if (i+T[i] <= N+1) {
				dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);				
			}
		}
		
		System.out.println(Math.max(dp[N], dp[N+1]));
	}
}
