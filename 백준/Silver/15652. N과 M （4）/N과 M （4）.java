
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr, resArr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 같은 수를 골라도 되는데
		// 비내림차순이어야함
		// 오름차순 처리와 같게 해주면 될듯?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		resArr = new int[M];
		
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		perm(0, 0);
		
		System.out.println(sb);
		
	}

	static void perm(int idx, int c) {
		// 다골랐당
		if (c == M) {
			for (int i=0; i<M; i++) {
				sb.append(resArr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=idx; i<N; i++) {
			resArr[c] = arr[i];
			perm(i, c+1);
		}
		
	}
}
