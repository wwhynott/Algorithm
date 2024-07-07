
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		// Enter가 입력될때마다 사람들의 인사횟수 초기화
		// 맵 사용! 리스트로 포함 여부 확인하면 오래걸린다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 기록 개수
		int N = Integer.parseInt(br.readLine());
		
//		// 리스트
//		List<String> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		// 곰곰티콘 사용된 횟수 
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			if (input.equals("ENTER")) {
				map.clear();
			} else {
				if (!map.containsKey(input)) { // 맵에 없다면 (enter 이후 첫 대화)
					map.put(input, null);
					cnt++;
				}
 			}
		}
		
		System.out.println(cnt);
	}
}
