
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE; 
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<N; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(min+" "+max);
	}
}
