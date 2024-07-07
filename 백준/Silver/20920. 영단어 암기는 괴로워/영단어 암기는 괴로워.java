
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class Alph {
		int cnt;
		String word;
		
		public Alph(int cnt, String word) {
			this.cnt = cnt;
			this.word = word;
		}
	}
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			
			if (input.length() < M) {
				continue;
			}
			
//			if (map.containsKey(input)) {
//				map.put(input, map.get(input)+1);
//			}
			// getOrDefault() 라는 함수로 빈도 체크 가능
			map.put(input, map.getOrDefault(input, 0)+1);
		}
		
		List<String> words = new ArrayList<>(map.keySet());
		
		// 정렬 (comparator)
		Collections.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 1. 자주 나오는 단어 (내림차순)
				if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
					return Integer.compare(map.get(o2), map.get(o1));
				}
				
				// 2. 단어의 길이가 길수록 (내림차순)
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				
				// 3. 알파벳 사전 순
				return o1.compareTo(o2);
			}
		});
		
		for (String word : words) {
			sb.append(word+"\n");
		}
		
		System.out.println(sb);
	}
}
