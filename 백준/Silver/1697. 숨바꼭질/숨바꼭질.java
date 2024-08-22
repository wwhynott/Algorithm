
import java.io.*;
import java.util.*;

public class Main {
	
	static class SB {
		int pos; // 위치
		int sec; // 시간
		
		SB(int pos, int sec) {
			this.pos = pos;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// bfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[100001];
		
		Queue<SB> queue = new LinkedList<>();
		
		queue.add(new SB(N, 0));
		int res = 0;
		
		while (!queue.isEmpty()) {
			SB next = queue.poll();
			visit[next.pos] = true;
			
			if (next.pos == K) {
				res = next.sec;
				break;
			}
			
			if (next.pos+1 <= 100000 && !visit[next.pos+1]) {
				queue.add(new SB(next.pos+1, next.sec+1));				
			} 
			if (next.pos-1 >= 0 && !visit[next.pos-1]) {
				queue.add(new SB(next.pos-1, next.sec+1));				
			}
			if (next.pos*2 <= 100000 && !visit[next.pos*2]) {
				queue.add(new SB(next.pos*2, next.sec+1));				
			}
		}
		
		System.out.println(res);
	}
}
