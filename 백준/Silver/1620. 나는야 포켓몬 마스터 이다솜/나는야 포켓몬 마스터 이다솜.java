
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 등록된 포켓몬 수
		int N = Integer.parseInt(st.nextToken());
		// 문제 수
		int M = Integer.parseInt(st.nextToken());
		
		// 포켓몬 저장 맵
		HashMap<Integer, String> intToString = new HashMap<>();
		HashMap<String, Integer> stringToInt = new HashMap<>();
		
		// 도감에 등록
		for (int i=1; i<=N; i++) {
			String name = br.readLine();
			
			intToString.put(i, name);
			stringToInt.put(name, i);
		}
		
		// 문제
		for (int i=0; i<M; i++) {
			String Q = br.readLine();
			if (isInteger(Q)) {
				sb.append(intToString.get(Integer.parseInt(Q))+"\n");
			} else {
				sb.append(stringToInt.get(Q)+"\n");
			}
		}
		System.out.println(sb);
	}
	
	// 입력이 문자인지 숫자인지 판단
	static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
