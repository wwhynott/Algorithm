
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[] gArr;
	
	public static void main(String[] args) throws Exception {
		// 유니온파인드?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		gArr = new int[G+1];
		for (int i=1; i<G+1; i++) {
			gArr[i] = i;
		}
		
		int res = 0;
		
		for (int i=0; i<P; i++) {
			int input = Integer.parseInt(br.readLine());
			int root = find(input);
			
			if (root == 0) break;
			
			res++;
			union(root, root-1);
		}
		
		System.out.println(res);
	}
	
	static int find(int a) {
		if (a == gArr[a]) {
			return a;
		} else {
			return gArr[a] = find(gArr[a]);
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			gArr[a] = b;
		}
	}
}
