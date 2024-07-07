
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] coinArr;
	static int res;
	static int tmp;
	
	public static void main(String[] args) throws Exception {
		// K를 완성시키는데 필요한 최소한의 동전 개수
		// 큰 가치의 동전부터 확인하면서 내려오기
		// K보다 큰 가치의 동전은 패스
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		res = 0;
		
		// 동전 보관
		coinArr = new int[N];
		
		for (int i=0; i<N; i++) {
			int coin = Integer.parseInt(br.readLine());
			
			coinArr[i] = coin;
		}
		
		tmp = K;
		getCoin(N-1); // 제일 큰 가치 동전부터 시작
		
		System.out.println(res);
	}

	static void getCoin(int idx) {
		// tmp가 0이 되면 리턴
		if (tmp == 0) {
			return;
		}
		
		// 동전의 가치 Ai에 대한 조건은...... 왜 있는거지........!
		// 남아있는 돈이(tmp) 음수가 되지 않을 만큼만 동전 사용하기
		// 현재 동전으로 tmp를 나눈 몫만큼만~
		int count = tmp/coinArr[idx];
		if (count > 0) {
			tmp -= count*coinArr[idx];
			res += count;
		}
		
		getCoin(idx-1);	
	}
}
