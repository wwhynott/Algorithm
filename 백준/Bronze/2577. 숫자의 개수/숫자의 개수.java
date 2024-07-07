
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int res = A*B*C;
		
		int[] arr = new int[10];
			
		for (int i=0; i<Integer.toString(res).length(); i++) {
			int x = Integer.toString(res).charAt(i)-'0';
			
			arr[x]++;
		}
		
		for (int i=0; i<10; i++) {
			System.out.println(arr[i]);
		}
	}
}
