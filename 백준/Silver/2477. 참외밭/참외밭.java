
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 입력받는 모든 변의 길이를 가지는 직사각형의 넓이를 더해주고 
		// (이러면 작은 직사각형 면적은 2번, 큰 직사각형 면적은 3번 더해짐)
		// 큰 직사각형 면적을 2번 빼주면 최종 구하고자 하는 6각형 넓이
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 참외 개수
		int K = Integer.parseInt(br.readLine());

		// 가장 긴 가로 세로
		int rMax = Integer.MIN_VALUE;
		int cMax = Integer.MIN_VALUE;

		// 길이 저장 배열
		int[] arr = new int[6];

		// 육각형 정보 입력
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 가로세로 여부
			int rc = Integer.parseInt(st.nextToken());
			// 길이
			int len = Integer.parseInt(st.nextToken());

			arr[i] = len;

			// 가로
			if (rc <= 2) {
				if (len > rMax) {
					rMax = len;
				}
			} else { // 세로
				if (len > cMax) {
					cMax = len;
				}
			}
		}
		
		int sum = 0;
		// 모든 변 사용해서 넓이 구하기
		for (int i=0; i<5; i++) {
			sum += arr[i]*arr[i+1];
		}
		sum += arr[0]*arr[5];
		
		// 큰 직사각형 두번 빼기
		sum -= 2*(rMax*cMax);
		
		// 참외 개수 곱해서 출력
		System.out.println(sum*K);
	}
}
