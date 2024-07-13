import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int v, w; // 도시번호, 버스비
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static final int INF = 987654321;
	static int N, M;
	static List<Node>[] adjList; // 인접리스트
	static int[] priceArr;
	
	public static void main(String[] args) throws Exception {
		// 다익스트라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
	
		priceArr = new int[N+1];
		Arrays.fill(priceArr, INF);
		
		adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList[c1].add(new Node(c2, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(priceArr[end]);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		
		priceArr[start] = 0;
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (visit[curr.v]) continue;
			
			visit[curr.v] = true;
			
			for (Node node : adjList[curr.v]) {
				if (!visit[node.v] && priceArr[node.v] > priceArr[curr.v]+node.w) {
					priceArr[node.v] = priceArr[curr.v]+node.w;
					pq.add(new Node(node.v, priceArr[node.v]));
				}
			}
		}
		
	}
}
