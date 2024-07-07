
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치 개수
		int N = Integer.parseInt(br.readLine());
		// 스위치 상태
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 스위치 상태 배열에 입력
		int[] switchArr = new int[N];
		for (int i=0; i<N; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 수
		int M = Integer.parseInt(br.readLine());
		
		for (int i=0; i<M; i++) {
			StringTokenizer student = new StringTokenizer(br.readLine());
			// 성별
			int gender = Integer.parseInt(student.nextToken());
			// 받은 수
			int num = Integer.parseInt(student.nextToken());
			
			// 성별에 따른 스위치 조작
			if (gender == 1) { // 남학생일때
				// 받은 수의 배수에 해당하는 스위치 상태 바꾼다
				for (int j=0; j<N; j++) {
					if ((j+1) % num == 0) { 
						if (switchArr[j] == 1) {
							switchArr[j] = 0;
						} else {
							switchArr[j] = 1;
						}
					}
				}
			} else { // 여학생일때
				// 받은 수를 중심으로 좌우가 대칭인 가장 넓은 범위 스위치 상태 바꾼다
				int range = 0; // 대칭 범위 변수
				int l = num-2;
				int r = num; // 좌우 탐색 idx
				if ( num != 1 && num != N // 맨 끝 스위치 아닌지
						&& switchArr[l] == switchArr[r]) { // 바로 양 옆 대칭인지 확인
					range++;
					for (int j=0; l-range>=0 && r+range<N; j++) {
						if (switchArr[l-range] == switchArr[r+range]) {
							range++;
						} else {
							break;
						}
					}
					// l부터 r까지 스위치 상태 바꾸기
					for (int j=num-1-range; j<=num-1+range; j++) {
						if (switchArr[j] == 1) {
							switchArr[j] = 0;
						} else {
							switchArr[j] = 1;
						}
					}
					
				} else {
					if (switchArr[num-1] == 1) {
						switchArr[num-1] = 0;
					} else {
						switchArr[num-1] = 1;
					}
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.print(switchArr[i]+" ");
			// 20개씩 출력 끊어주기
			if ((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}