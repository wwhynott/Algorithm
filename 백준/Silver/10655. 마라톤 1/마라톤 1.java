
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		// 첫번째, 마지막을 제외한 체크포인트를 하나씩 건너뛰어보면서 완탐....(2중for문) 했더니 시간초과
		// 모든 체크포인트를 들렀을때 거리를 일단 구하고
		// 각 체크포인트를 건너뛸때 거리를 다시 구해보기?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Point[] cpArr = new Point[N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			cpArr[i] = new Point(x, y);
		}
		
		// 모든 체크포인트 가는 경우 거리
		int totDist = 0;
		for (int i=1; i<N; i++) {
			totDist += Math.abs(cpArr[i].x-cpArr[i-1].x)+Math.abs(cpArr[i].y-cpArr[i-1].y);
		}
		
		// 체크포인트 하나씩 건너뛰어보기
		int min = totDist;
		for (int i=1; i<N-1; i++) {
			// 건너뛸 체크포인트의 앞뒤 체크포인트 이어주기
			// (건너뛸체크포인트&직전포인트 + 건체&다음포인트) 거리빼고 직전포인트&다음포인트 거리 더해주기
			int dist = totDist - (Math.abs(cpArr[i].x-cpArr[i-1].x)+Math.abs(cpArr[i].y-cpArr[i-1].y))
					- (Math.abs(cpArr[i+1].x-cpArr[i].x)+Math.abs(cpArr[i+1].y-cpArr[i].y))
					+ (Math.abs(cpArr[i+1].x-cpArr[i-1].x)+Math.abs(cpArr[i+1].y-cpArr[i-1].y));
			
			min = Math.min(dist, min);
		}
		
		System.out.println(min);
	}
}
