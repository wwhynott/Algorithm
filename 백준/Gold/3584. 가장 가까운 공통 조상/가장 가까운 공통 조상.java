
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int num;
	Node parent;
	
	Node() {
		
	}
	
	Node(int num) {
		this.num = num;
	}
}


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 개수 
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			// 노드 개수
			int N = Integer.parseInt(br.readLine());
			
			// 노드 보관 배열 
			Node[] nodes = new Node[N+1]; // idx 1부터 사용
			for (int i=1; i<=N; i++) {
				nodes[i] = new Node(i);
			}

			// 부모 연결
			for (int i=1; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				nodes[c].parent = nodes[p];
			}
			
			// 탐색 노드 a, b
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a의 조상 리스트
			List<Integer> list = new ArrayList<>();
			// 먼저 자기 자신 넣기
			list.add(a);
			findP(nodes, list, a);

			// 리스트 돌면서 b의 조상 찾기
			while (!list.contains(nodes[b].num)) {
				b = nodes[b].parent.num;
			}
			
			System.out.println(nodes[b].num);
		}
	}
	
	static void findP(Node[] arr, List<Integer> list, int num) {
		if (arr[num].parent == null) {
			return;
		}
		list.add(arr[num].parent.num);
		num = arr[num].parent.num;
		findP(arr, list, num);
	}
	

}
