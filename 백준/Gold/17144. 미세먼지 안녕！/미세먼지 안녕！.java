
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, T;
	static int[][] map, diffMap; // 원본맵, 확산맵
	static int lC; // 아래쪽 공청기 위치
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		// map을 두개 두고?
		// 원본맵, 확산용 맵
		// 확산용 맵에다가 확산만 시켜놓고
		// 원본맵에는 확산하고 남은 애들을 원래자리에 남겨놓은 다음
		// 확산용 맵에 더해주기!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		lC = 0;
		
		map = new int[R][C];
		diffMap = new int[R][C];
		
		for (int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<C; c++) {
				int input = Integer.parseInt(st.nextToken());
				
				// 일단 입력해
				map[r][c] = input;
				
				// 먼저 발견되는 공청기 (r1, 0) 
				// -> 위쪽 공기순환 r1행부터 반시계 빙글빙글
				// 나중에 발견되는 공청기 (r2, 0)
				// -> 아래쪽 공기순환 r2행부터 시계 빙글빙글
				
				if (input == -1) { // 공청기다!
					lC = r; // 아래쪽 공청기
				}
			}
		}
		
		
		while(T > 0) {
			
			// 미세먼지 확산
			diffusion();
			
			// 공청기 가동 (확산맵에서 진행)
			airCleaning();
			
			// 확산맵 -> 원본맵 복사
			for (int r=0; r<R; r++) {
				for (int c=0; c<C; c++) {
					map[r][c] = diffMap[r][c];
				}
			}
			// 확산맵 초기화
			diffMap = new int[R][C];
			
			T--;
		}
		
		// 남아있는 미먼 ?
		int res = 0;
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				if (map[r][c] != -1) {
					res += map[r][c] ;
				}
			}
		}
		
		System.out.println(res);

	}

	
	static void diffusion() {
		// 돌면서 5 이상인 위치를 찾기
		// (5 미만이면 확산이 일어나지 않아영)
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				int cnt = 0; // 확산할 수 있는 방향 카운트
				
				if (map[r][c] >= 5) { // 확산하는 미세먼지다!
					for (int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						// 경계 밖도 아니고 공청기도 아니다?
						if (nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc] != -1) {
							cnt++; // 확산 고 ~
							diffMap[nr][nc] += map[r][c]/5;
						}
					}
				}
				
				// 확산 다했어영
				map[r][c] -= (map[r][c]/5)*cnt; // 확산한 만큼 원래 자리에서 뻬주기
			}
		}
		
		// 원본맵에 남은 미먼 확산맵으로 옮겨주기 ~
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				// 공청기가 아닌 칸만 ~
				if (map[r][c] != -1) {
					diffMap[r][c] += map[r][c];					
				}
			}
		}
	}
	
	
	static void airCleaning() {
		// 먼지 밀어내기~
		
		// 위
		// 0~lC-1행 & 0열 아래로 밀기
		for (int r=lC-2; r>=0; r--) {
			diffMap[r+1][0] = diffMap[r][0];
		}
		
		// 0행 왼쪽으로 밀기
		for (int c=1; c<C; c++) {
			diffMap[0][c-1] = diffMap[0][c]; 
		}
		
		// 0~lC-1행 & C-1열 위로 밀기
		for (int r=1; r<=lC-1; r++) {
			diffMap[r-1][C-1] = diffMap[r][C-1];
		}
		
		// lC-1행 오른쪽으로 밀기
		for (int c=C-2; c>=1; c--) {
			diffMap[lC-1][c+1] = diffMap[lC-1][c];
		}
		
		// 공청기 바로 옆에있던 공기 0으로
		diffMap[lC-1][1] = 0;
		
		// 아래
		// lC~R-1행 & 0열 위로 밀기
		for (int r=lC; r<R; r++) {
			diffMap[r-1][0] = diffMap[r][0]; 
		}
		
		// R-1행 왼쪽으로 밀기
		for (int c=1; c<C; c++) {
			diffMap[R-1][c-1] = diffMap[R-1][c];
		}
		
		// lc~R-1행 & C-1열 아래로 밀기
		for (int r=R-2; r>=lC; r--) {
			diffMap[r+1][C-1] = diffMap[r][C-1];
		}
		
		// lC행 오른쪽으로 밀기
		for (int c=C-2; c>=1; c--) {
			diffMap[lC][c+1] = diffMap[lC][c];
		}
		
		// 공청기 바로 옆에있던 공기 0으로
		diffMap[lC][1] = 0;
		
		// 공청기 다시 입력!
		diffMap[lC-1][0] = -1;
		diffMap[lC][0] = -1;
	}
}
