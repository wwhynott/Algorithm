
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int danji, house; // 단지 수, 단지 내 집의 수
	static List<Integer> res; // 단지내 집의 수 보관 리스트
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		danji = 0;
		res = new ArrayList<>();
		
		for (int r=0; r<N; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c=0; c<N; c++) {
				map[r][c] = input[c]-'0';
			}
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (map[r][c] == 1) { // 집?
					if (!visit[r][c]) { // 방문한적 없는 단지? 
						house = 0;
						dfs(r, c);
						danji++;
						res.add(house);						
					}
				}
			}
		}
		
		Collections.sort(res);
		
		System.out.println(danji);
		for (int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
		
	}


	static void dfs(int r, int c) {
		// 더이상 갈곳 없다
		if (visit[r][c]) {
			return;
		}
		
		visit[r][c] = true;
		house++; // 단지 내 집의 수 ++
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<N && nc>=0 && nc<N) {
				if (map[nr][nc] == 1) {
					dfs(nr, nc);					
				}
			}
		} 
		
	}
}
