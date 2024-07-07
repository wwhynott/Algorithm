
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 맵에 N개의 사이트와 비밀번호 저장
		// M개의 비밀번호 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			String site = st2.nextToken();
			String pwd = st2.nextToken();
			
			map.put(site, pwd);
		}
		
		for (int i=0; i<M; i++) {
			String site = br.readLine();
			
			sb.append(map.get(site)+"\n");
		}
		
		System.out.println(sb);
	}
}
