
import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static Map<String, String> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		
		StringTokenizer st;
		String name, log;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			log = st.nextToken();
			if (map.containsKey(name)) {
				map.remove(name);
			} else {
				map.put(name, log);				
			}
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet, Collections.reverseOrder());
		
		for (String key : keySet) {
			sb.append(key).append("\n");
		}
		
		System.out.println(sb);
	}
}
