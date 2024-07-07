
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate> {
	int x;
	int y;
	
	public Coordinate() {
		
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Coordinate o) {
		if (this.x == o.x) {
			return this.y - o.y;			
		}
		return this.x - o.x;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Coordinate> pq = new PriorityQueue<>();

		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.add(new Coordinate(x, y));
		}
		
		while (!pq.isEmpty()) {
			System.out.println(pq.peek().x+" "+pq.peek().y);
			pq.poll();
		}
		
	}
}
