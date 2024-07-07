import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, C, W; // 나무 개수, 자르는 비용, 나무 가격
	static int[] treeArr; // 나무 길이 보관 배열
	static long pCnt; // 나무 조각 개수
	static long res; // 결과 저장
	
	public static void main(String[] args) throws Exception {
		// 나무길이 1 ~ 제일 긴 나무 완탐 고고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		treeArr = new int[N];
		
		int max = 0; // 나무 길이 최대값
		res = 0; // 최대값 저장 
		
		for (int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			treeArr[i] = input;
			max = Math.max(max, input);
		}
		
		// 1부터 max까지 잘라볼게영
		for (int i=1; i<=max; i++) {
			pCnt = 0; // 나무 조각 개수 초기화			
			
			long cutCost = cuttingCnt(i) * C;
			
			long cost = (pCnt * i * W) - cutCost;
			
			res = Math.max(res, cost);
			
		}
		
		System.out.println(res);

	}
	
	// len : 자를 길이
	static long cuttingCnt(int len) {
		// 모든 나무를 len만큼의 길이로 자르는데 드는 비용 구하기 (자르는 횟수 + 잘린 조각 개수도 업데이트)
		
		long cnt = 0; // 나무 컷팅 횟수 
		
		for (int i=0; i<N; i++) {
			int tree = treeArr[i];
			if (tree < len) {
				continue;
			}
			
			int nowCnt = 0;
			
			if (tree % len == 0) {
				nowCnt = (tree/len)-1;
				cnt += nowCnt;
			} else { 
				nowCnt = tree/len;
				cnt += nowCnt;
			}

			// 나무 조각 개수 업데이트
			pCnt += tree/len;
			
			// 만약 자르는 비용이 팔아서 얻는 이득보다 많다? 이 나무 안잘라~
			if ((nowCnt * C) > ((tree/len) * len * W)) {
				cnt -= nowCnt; // cnt 원복
				pCnt -= tree/len; // pCnt 원복
			}
			
		}
		
		return cnt;
	
	}

}
