import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	// 노드 연결 정보 저장 배열 
	static List<Integer>[] connInfo;
	// 노드 방문 여부 배열
	static boolean[] visit;
	// 턴 수
	static int res = 0;
	// 노드의 깊이
	static int depth = 0;
	
	public static void main(String[] args) throws Exception {
		// 일단 노드끼리 연결해서 트리를 완성하고
		// 모든 리프노드의 깊이가 몇인지 파악
		// -> 모든 말이 나가는데 걸리는 턴 수 = 리프노드 깊이의 합
		// 홀수(성원이 차례)면 이길 수 있다!
		
		// 노드를 클래스로 구현해서 시간초과가 나는건가?......
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N+1];

		// 연결 정보 저장 배열
		connInfo = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();			
		}
		
		// 간선 연결 정보 N-1줄
		for (int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			connInfo[a].add(b);
			connInfo[b].add(a);
		}
		
		// 루트 1번부터 연결 시작
		connectNode(1);
		
		// 총 합이 홀수이면 이길 수 있다
		if (res % 2 != 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}
	
	static void connectNode(int idx) {
		visit[idx] = true; // 방문 노드 표시
		
		// 리프노드일때 리턴
		if (idx != 1 && connInfo[idx].size() == 1) {
			res += depth;
			return;
		}
		
		// 해당 노드에 연결된 노드를 모두 돌면서
		// 그 노드를 방문한 적이 없으면 그 노드는 현재 idx의 자식
		for (int i: connInfo[idx]) {
			if (visit[i] == false) {
				depth++;
				connectNode(i);
				depth--;
			} 
		}
	}

}
