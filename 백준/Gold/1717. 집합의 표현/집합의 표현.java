
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m; // 집합 개수, 연산 개수
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n+1]; // 집합은 0부터 시작, n+1개의 집합
		
		// 0~n 집합 makeset
		for (int i=0; i<=n; i++) {
			p[i] = i;
		}
		
		// m개의 연산
		for (int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int op = Integer.parseInt(st2.nextToken());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			
			if (op == 0) { // union
				int px = findset(x);
				int py = findset(y);
				
				if (px != py) {
					p[py] = px;
				}
			} else { // findset
				if (findset(x) == findset(y)) {
					sb.append("YES"+"\n");
				} else {
					sb.append("NO"+"\n");
				}
			}
		}
		System.out.println(sb);
	}

	static int findset(int x) {
		if (p[x] != x) {
			p[x] = findset(p[x]);
		}
		
		return p[x];
	}
}
