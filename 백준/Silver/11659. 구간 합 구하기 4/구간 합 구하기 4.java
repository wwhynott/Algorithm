
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] prefixSumArr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		prefixSumArr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		int prefixSum = 0;
		for (int i=1; i<=N; i++) {
			int input = Integer.parseInt(st.nextToken());
			prefixSum += input;
			prefixSumArr[i] = prefixSum;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int res = prefixSumArr[b] - prefixSumArr[a-1];
			sb.append(res+"\n");
		}
		
		System.out.println(sb);
	}
}
