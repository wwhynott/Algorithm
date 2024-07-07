
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] health = new int[N+1];
		int[] happy = new int[N+1];
		
		// 잃는 체력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		
		// 얻는 기쁨
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			happy[i] = Integer.parseInt(st2.nextToken());
		}
		
		int[][] dp = new int[N+1][101]; // N번까지의 사람 고려하고 체력 100만큼만
		
		// 1~N번 사람 고려
		for(int i=1; i<=N; i++) {
			for(int h=0; h<=100; h++) { // 임시로 가정할 최대 체력?
				if (health[i] <= h) {
					dp[i][h] = Math.max(dp[i-1][h], dp[i-1][h-health[i]]+happy[i]);
				} else {
					dp[i][h] = dp[i-1][h];
				}
				
			}
			
		}
        // 체력 100이면 죽으니까 99까지만..
		System.out.println(dp[N][99]);
		
	}
}
