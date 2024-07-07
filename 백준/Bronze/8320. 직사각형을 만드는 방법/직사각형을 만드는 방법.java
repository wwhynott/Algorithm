
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// (N/1)-0 + (N/2)-1 + (N/3)-2 + (N/4)-3 + ...
		// 이런 식의 반복
		// 한 덩어리가 음수이면 그 이후는 계산에 포함하지 않는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int res = calc(n, 1);
		
		System.out.println(res);
		
	}
	
	static int calc(int n, int idx) {
		int res = (n/idx)-(idx-1);
		
		if (res < 0) {
			return 0;
		}
		
		return res + calc(n, idx+1);
	}
}
