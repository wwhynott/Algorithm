
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		
		/* 카운팅 정렬 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		countingSort();
		
		for (int a : arr) {
			sb.append(a+"\n");
		}
		
		System.out.println(sb);
	}

	static void countingSort() {
		int[] counting = new int[10001];
		int[] output = new int[N];
		
		// counting
		for (int i=0; i<N; i++) {
			counting[arr[i]]++;
		}
		
		// 누적합
		for (int i=1; i<10001; i++) {
			counting[i] += counting[i-1];
		}
		
		for (int i=N-1; i>=0; i--) {
			output[--counting[arr[i]]] = arr[i];
		}
		
		for (int i=0; i<N; i++) {
			arr[i] = output[i];
		}
	}	
	
}
