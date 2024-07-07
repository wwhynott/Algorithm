
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer>[] connInfo;
	static int[] degree; // 진입차수
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());
		connInfo = new ArrayList[N+1]; // 학생번호 1번부터
		for (int i=0; i<N+1; i++) {
			connInfo[i] = new ArrayList<>();
		}
		degree = new int[N+1];
		queue = new LinkedList<>();
		
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());
			
			connInfo[A].add(B);
			degree[B]++;
		}
		
		for (int i=1; i<N+1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
				
		while (!queue.isEmpty()) {
			int next = queue.poll();
			
			for (int i : connInfo[next]) {
				degree[i]--;
				
				if (degree[i] == 0) {
					queue.add(i);
				}
			}
			
			sb.append(next+" ");		
		}
		
		System.out.println(sb);
	}
}
