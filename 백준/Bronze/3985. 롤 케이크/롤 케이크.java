
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// L 만큼의 길이를 가진 배열 생성 후
		// 각 방청객이 원하는 범위에 방청객의 번호 1 -> N 순서대로 배열에 입력
		// ex. 2~4 범위를 원했다면 배열의 1~3 idx에 채워짐
		
		// 가장 긴 범위를 입력한 방청객 번호와
		// 실제 배열에 가장 많이 있는 번호 확인
		// (두 기대값이 여러개라면 가장 작은 번호 출력)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int L = Integer.parseInt(br.readLine()); // 롤케이크 길이
		int	N = Integer.parseInt(br.readLine()); // 방청객의 수
		
		// 롤케이크 배열
		int[] cakeArr = new int[L];
		
		// 기대한 조각 개수 최대값 
		int expectMax = 0;
		// 방청객 번호
		int num = 0;
		
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int expectCnt = k-p+1;
			
			if (expectCnt > expectMax) {
				num = i; // 클 경우만 업데이트 하므로 작은 방청객으로 유지
				expectMax = expectCnt;
			}
			
			for (int j=p-1; j<=k-1; j++) {
				if (cakeArr[j] == 0) { // 먼저 고른사람이 없을때만
					cakeArr[j] = i;					
				}
			}
		}
		sb.append(num+"\n");
		
		// 실제로 가장 많이 받은 방청객
		// 카운트배열?
		int[] peopleArr = new int[N+1];
		for (int i=1; i<=N; i++) {
			for (int j=0; j<L; j++) {
				if (cakeArr[j] == i) {
					peopleArr[i]++;
				}
			}
		}
		
		int rMax = 0;
		int rNum = 0;
		for (int i=1; i<=N; i++) {
			if (peopleArr[i] > rMax) {
				rMax = peopleArr[i];
				rNum = i;
			}
		}
		
		sb.append(rNum);
		System.out.println(sb);
		
		
	}
}
