
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// 우선 컵홀더 배치하고
		// 컵홀더 수가 좌석 수보다 크거나 같으면 좌석 수를 출력하고
		// 그 외에는 컵홀더 수를 출력한다
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String seat = br.readLine();
		
		int holderCnt = 1; // 컵홀더 개수 (맨 왼쪽 끝에 하나 놓고 시작)
		
		for (int i=0; i<seat.length(); i++) {
			if (seat.charAt(i) == 'S') { // idx 넘어가면서 cnt ++
				holderCnt++;
			} else { // 커플석이면 idx 두번에 cnt 한번
				holderCnt++;
				i++;
			}
		}
		
		if (holderCnt >= N) {
			System.out.println(N);
		} else {
			System.out.println(holderCnt);
		}
		
	}
}
