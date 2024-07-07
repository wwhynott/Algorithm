
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// k층 n호의 사람 수 구하기
		
		// 0층 1호 = 1명  0층 2호 = 2명  0층 3호 = 3명  0층 4호 = 4명
		// 1층 1호 = 1명  1층 2호 = 3명  1층 3호 = 6명  1층 4호 = 10명
		// 2층 1호 = 1명  2층 2호 = 4명  2층 3호 = 10명 2층 4호 = 20명
		// 3층 1호 = 1명  3층 2호 = 5명  3층 3호 = 15명 3층 4호 = 35명
		// k-1층 n호 + k층 n-1호 = k층 n호
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			int k = Integer.parseInt(br.readLine()); // 층
			int n = Integer.parseInt(br.readLine()); // 호
			
			int p = getPeople(k, n);
			
			sb.append(p+"\n");
		}
		System.out.println(sb);
	}

	static int getPeople(int k, int n) {
		int people = 0;
		
		if (k == 0) {
			return n;
		}
		if (n == 0) {
			return 0;
		}
		
		people = getPeople(k-1, n) + getPeople(k, n-1);
		
		return people;
	}

}
