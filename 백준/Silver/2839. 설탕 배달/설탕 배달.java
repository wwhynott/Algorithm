
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// 5키로짜리 봉지를 최대한 많이 가져가는거부터 시작해서 하나씩 줄여나가면서
		// 남은 설탕이 3의 배수가 되는지 확인
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int max5cnt = N / 5;
		
		int cnt5 = 0;
		int cnt3 = 0;
		
		for (int i=max5cnt; i>=0; i--) {
			// 5키로짜리 봉지로 배달했을때 남은 설탕 무게
			int x = N-(5*i);
			if (x % 3 == 0) { // 남은 설탕 무게가 3으로 딱 나눠질때
				cnt5 = i;
				cnt3 = x/3;
				break;
			}
		}
		
		// for문이 끝나고도 cnt5,3이 업데이트 되지 않았을 때
		if (cnt5 == 0 && cnt3 == 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt5+cnt3);
		}

	}
}
