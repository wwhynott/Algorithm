
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 듣못 & 보못 두 그룹 모두 속하는 사람 구하기
		// contain 사용해서 두 그룹에 속하는지 확인하기
		// List 쓰면 오래걸림.. map?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> noHeard = new HashMap<>();
		HashMap<String, Integer> noSeen = new HashMap<>();
		Set<String> all = new HashSet<>();
		
		for (int i=0; i<N; i++) {
			String noH = br.readLine();
			noHeard.put(noH, 0);
			all.add(noH);
		}
		
		for (int i=0; i<M; i++) {
			String noS = br.readLine();
			noSeen.put(noS, 0);
			all.add(noS);
		}
		
		// set 돌면서 두 그룹 모두 속하는지 확인
		int cnt = 0;
		List<String> res = new ArrayList<>();
		Iterator<String> it = all.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			if (noHeard.containsKey(tmp) && noSeen.containsKey(tmp)) { // 듣보?
				cnt++;
				res.add(tmp);
			}
		}
		
		Collections.sort(res);
		
		System.out.println(cnt);
		for(int i=0; i<cnt; i++) {
			System.out.println(res.get(i));
		}
		
		
	}
}
