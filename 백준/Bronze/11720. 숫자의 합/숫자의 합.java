
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] arr = new char[N];
		
		arr = br.readLine().toCharArray();
		
		int res = 0;
		
		for (int i=0; i<N; i++) {
			res += arr[i]-'0';
		}
		
		System.out.println(res);
	}
}
