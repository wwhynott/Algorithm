
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr; // 1~N
	static int[] resArr; // M개의 수
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		// 오름차순인 수열만 출력한다~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];
		resArr = new int[M];
		
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		perm(0, 0);
		
	}

	// idx : arr 배열의 인덱스 / c : 고른 개수 (resArr 인덱스)
	static void perm(int idx, int c) {
		// 다고르면 나와
		if (c == M) {
			for (int i=0; i<M; i++) {
				System.out.print(resArr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 오름차순으로만 골라야 해염
		for (int i=idx; i<N; i++) {
			if (!visit[i]) {
				// 고른다~
				visit[i] = true;
				resArr[c] = arr[i];
				perm(i+1, c+1);
				visit[i] = false; // 안고를거다
			}
		}
	}
}
