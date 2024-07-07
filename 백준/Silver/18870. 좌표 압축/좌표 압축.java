
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] sortArr = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = input;
			sortArr[i] = input;
		}
		
		// 배열 정렬
		Arrays.sort(sortArr);
		
		int rank = 0;
		for (int i=0; i<N; i++) {
			if(!map.containsKey(sortArr[i])) {
				map.put(sortArr[i], rank);
				rank++;
			}
		}
		
		for (int i=0; i<N; i++) {
			sb.append(map.get(arr[i])+" ");
		}
		
		System.out.println(sb);
		
	}
}
