
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr, resArr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		resArr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		perm(0);
		
		System.out.println(sb);
	}

	static void perm(int c) {
		// 다고름
		if (c == M) {
			for (int i=0; i<M; i++) {
				sb.append(resArr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<N; i++) {
			resArr[c] = arr[i];
			perm(c+1);
		}
		
	}
}
