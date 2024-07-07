
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 칭호 개수
		int M = Integer.parseInt(st.nextToken()); // 캐릭터 개수
		
		// 중복확인을 List에서 하면 시간 오래걸림,,, map에서 확인하자 ~
		HashMap<Integer, String> titleMap = new HashMap<>();
		List<Integer> powerList = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer titleTokens = new StringTokenizer(br.readLine());
			
			String title = titleTokens.nextToken();
			int power = Integer.parseInt(titleTokens.nextToken());
			
			if (!titleMap.containsKey(power)) {				
				titleMap.put(power, title);
				powerList.add(power);
			}
		}
		
		Collections.sort(powerList);

		for (int i=0; i<M; i++) {
			int cPower = Integer.parseInt(br.readLine());
			// 캐릭터 전투력을 칭호 전투력 리스트에서 찾아보고
			// 전투력과 일치한다면 or 전투력보다 작은 위치에 있다면(들어갈 위치를 음수로 표현해줌)
			// 해당 칭호를 출력한다
			int charIdx = Collections.binarySearch(powerList, cPower);
			if (charIdx < 0) {
				charIdx = (-charIdx)-1; // = 캐릭터에 해당하는 칭호 idx
			}
			sb.append(titleMap.get(powerList.get(charIdx))+"\n");
		}
		System.out.println(sb);
	}
}
