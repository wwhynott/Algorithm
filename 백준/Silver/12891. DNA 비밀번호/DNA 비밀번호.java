
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 한 칸씩 슬라이딩 하면서 조건 만족하는지 확인해보자~
		// S-P+1 번 확인해야 하겠죵
		
		// 한 칸씩 이동할때마다 새로 카운팅하면 시간초과... ㅠ 당연
		// 이동할때 맨 앞꺼 cnt-- 해주고 새로 받는거 cnt++ 해주자 ~
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 비밀번호 종류
		int res = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] input = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int aCnt = 0;
		int cCnt = 0;
		int gCnt = 0;
		int tCnt = 0;
		
		// input.substring(i, i+P)
		for (int i=0; i<S-P+1; i++) {
			// 처음은 정석대로 확인해주고
			if (i == 0) {
				for (int j=i; j<P; j++) {
					switch (input[j]) {
						case 'A':
							aCnt++;
							break;
						case 'C':
							cCnt++;
							break;
						case 'G':
							gCnt++;
							break;
						case 'T':
							tCnt++;
							break;
					}
				}
			} else { // 앞쪽 nt cnt-- 맨뒤 nt cnt++
				switch (input[i-1]) {
					case 'A':
						aCnt--;
						break;
					case 'C':
						cCnt--;
						break;
					case 'G':
						gCnt--;
						break;
					case 'T':
						tCnt--;
						break;
				}
				switch (input[i+P-1]) {
					case 'A':
						aCnt++;
						break;
					case 'C':
						cCnt++;
						break;
					case 'G':
						gCnt++;
						break;
					case 'T':
						tCnt++;
						break;
				}
			}
			if (aCnt >= a && cCnt >= c && gCnt >= g && tCnt >= t) {
				res++;
			}
		}
		
		System.out.println(res);
	}
}
