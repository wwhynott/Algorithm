
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 라운드 횟수
		
		for (int i=0; i<N; i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			
			int numsA = Integer.parseInt(stA.nextToken());
			int numsB = Integer.parseInt(stB.nextToken());
			
			// A, B의 카드 종류별 개수
			int cntA4 = 0;
			int cntA3 = 0;
			int cntA2 = 0;
			int cntA1 = 0;
			int cntB4 = 0;
			int cntB3 = 0;
			int cntB2 = 0;
			int cntB1 = 0;
			
			// A
			for (int a=0; a<numsA; a++) {
				int cardA = Integer.parseInt(stA.nextToken());
				switch (cardA) {
					case 4: {
						cntA4++;
						break;
					}
					case 3: {
						cntA3++;
						break;
					}
					case 2: {
						cntA2++;
						break;
					}
					case 1: {
						cntA1++;
						break;
					}
				}
			}
			
			// B 
			for (int b=0; b<numsB; b++) {
				int cardB = Integer.parseInt(stB.nextToken());
				switch (cardB) {
					case 4: {
						cntB4++;
						break;
					}
					case 3: {
						cntB3++;
						break;
					}
					case 2: {
						cntB2++;
						break;
					}
					case 1: {
						cntB1++;
						break;
					}
				}
			}
			
			// 비교~
			if (cntA4 > cntB4) {
				sb.append("A\n");
			} else if (cntA4 < cntB4) {
				sb.append("B\n");
			} else { // 별 카드 개수 같다면
				if (cntA3 > cntB3) {
					sb.append("A\n");
				} else if (cntA3 < cntB3) {
					sb.append("B\n");
				} else { // 동그라미
					if (cntA2 > cntB2) {
						sb.append("A\n");
					} else if (cntA2 < cntB2) {
						sb.append("B\n");
					} else { // 세모
						if (cntA1 > cntB1) {
							sb.append("A\n");
						} else if (cntA1 < cntB1) {
							sb.append("B\n");
						} else { // 모두 같다
							sb.append("D\n");
						}
					}
				}
				
			}

		}
		System.out.println(sb);
		
	}
}
