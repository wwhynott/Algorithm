
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;
	static Number[] arr;
	
	static class Number implements Comparable<Number>{
		int num;
		int idx;
		
		public Number(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}

		@Override
		public int compareTo(Number o) {
			return this.num - o.num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 버블소트 몇 사이클째에 정렬되는지 출력하기
		// 이미 정렬되어있으면 1
		
		// 앞쪽으로 가장 많이 이동한 숫자의 이동횟수 +1가 정답
		// (버블정렬시 뒤쪽으로 이동은 여러번 가능, 앞쪽으로 이동은 1턴당 1번)
		
		// 정렬 후 원래 인덱스와 차이 확인
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사이클
		int max = 0;
		
		N = Integer.parseInt(br.readLine());
		arr = new Number[N];
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = new Number(num, i);
		}
		Arrays.sort(arr);
		
		for (int i=0; i<N; i++) {
			max = Math.max(max, arr[i].idx-i+1);
		}
		
		System.out.println(max);
	}
}
