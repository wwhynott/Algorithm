
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr; // 1부터 N까지 보관
	static int[] resArr; // 수열 결과 저장
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		// 1부터 N까지 수 중 M개를 고르는 수열 모두 출력하기
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
		
		perm(0);
	}

	// c : 지금까지 고른 개수
	static void perm(int c) {
		// M개 다 골랐다~
		if (c == M) {
			for (int i=0; i<M; i++) {
				System.out.print(resArr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!visit[i]) { // 아직 사용하지 않은 요소다?
				// 이제 쓸거다
				visit[i] = true;
				resArr[c] = arr[i];
				perm(c+1);
				// 안쓸거다
				visit[i] = false;
			}
		}

		
	}
}
