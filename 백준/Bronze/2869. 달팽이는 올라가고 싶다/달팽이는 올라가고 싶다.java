
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 달팽이가 낮에 올라가는 미터
		int A = Integer.parseInt(st.nextToken());
		// 밤에 미끄러지는 미터
		int B = Integer.parseInt(st.nextToken());
		// 막대의 높이
		int V = Integer.parseInt(st.nextToken());
		
		// 걸린 날짜
		int date = (V-B)/(A-B);
		
		// 나머지가 있다면? 
		if ((V-B) % (A-B) != 0) {
			date++;
		}
		
		System.out.println(date);
		
		// 도달하는 날 x
		// 올라가는 횟수 x, 내려가는 횟수 x-1
		// Ax - B(x-1) >= V
		// x >= (V-B)/(A-B)
	}
}
