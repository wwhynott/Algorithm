
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 최대공약수
		// a > b 일때
		// a를 b로 나눴을때 나머지가 0이면 b가 최대공약수
		// 나머지가 0이 아니면 그 나머지로 b를 나눈다음
		// 나머지가 0일때까지 반복
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		
		int gcd = gcd(a,b);
		sb.append(gcd+"\n");
		// 최소공배수
		// 두 수를 곱한 값을 최대공약수로 나눈 값
		int lcm = (a*b)/gcd;
		sb.append(lcm);
		
		System.out.println(sb);
	
	}
	
	// 최대공약수
	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		
		return gcd(b, a%b);
	}
}
