
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// 모든 경우의 수 탐색
		// 100과의 차이 diff가 최소값일때
		// + diff가 같은 경우 더 큰값 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 버섯 배열
		int[] mushArr = new int[10];
		
		for (int i=0; i<10; i++) {
			int score = Integer.parseInt(br.readLine());
			mushArr[i] = score;
		}
		
		int diff = Integer.MAX_VALUE;
		int sum = 0;
		int res = 0;
		
		for (int i=0; i<10; i++) {
			sum += mushArr[i];
			if (Math.abs(100-sum) <= diff) {
				diff = Math.abs(100-sum);
				res = sum;
			}
		}
		
		System.out.println(res);
	}
}
