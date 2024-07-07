import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// 일급 보관 배열
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		// 최대 이익이 될 수 있는 최대값 (1,000,000 * 100,000) -> int형으로 출력 불가
		long max = Integer.MIN_VALUE;
		
		for (int i=0; i<=n-m; i++) {
			long sum = 0;
			for (int j=0; j<m; j++) {
				sum += arr[i+j];
			}
			if (max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
