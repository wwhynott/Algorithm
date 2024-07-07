import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 개수
		int N = Integer.parseInt(br.readLine());
		
		// 출력 스트링
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int count = st.countTokens();
			
			for (int j=0; j<count; j++) {
				StringBuffer word = new StringBuffer(st.nextToken());

				sb.append(word.reverse()+" ");
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	}
}