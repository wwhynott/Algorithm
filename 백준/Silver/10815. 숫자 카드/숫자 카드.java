
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 상근이가 가진 카드 개수
		int N = Integer.parseInt(br.readLine());
		// 가진 카드 리스트에 입력
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// 출력 스트링
		StringBuilder sb = new StringBuilder();
		
		// 확인할 카드 개수
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			int check = Integer.parseInt(st2.nextToken());
			sb.append(binarySearch(arr, check)+" ");
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int[] arr, int x) {
		int last = arr.length-1;
		int start = 0;
		
		while (start <= last) {
			int mid = (start+last)/2;
			
			if (arr[mid] > x) {
				last = mid-1;
			} else if (arr[mid] < x) {
				start = mid+1;
			} else {
				return 1;
			}
		}
		
		return 0;
	}
}
