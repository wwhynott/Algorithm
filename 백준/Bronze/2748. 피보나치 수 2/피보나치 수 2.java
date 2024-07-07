
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static long[] fiboArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		fiboArr = new long[n+1];
		
		long res = fibo(n);
		
		System.out.println(res);
	}

	static long fibo(int n) {
		fiboArr[0] = 0;
		if (n != 0) {
			fiboArr[1] = 1;			
		}
		
		for (int i=2; i<=n; i++) {
			fiboArr[i] = fiboArr[i-2]+fiboArr[i-1];
		}
		
		return fiboArr[n];
	}
}
