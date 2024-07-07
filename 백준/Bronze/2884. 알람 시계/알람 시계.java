import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 알람 시각 45분 앞선 시간으로 바꾸기
		// 입력되는 시간은 H M (24시간 표현)
		// 입력 시간보다 45분 이른 시각 출력하기 (24시간 표현)
		// 불필요한 0은 사용하지 않는다 (새벽 0시를 나타낼때만 사용)
		
		// 1. 분 단위가 45분 미만일때 -> 시 단위 -1 & 분 단위 = (60 + 현재분) - 45
		// 1-1. 시 단위가 0일 시, 24로 변환 후 -1 or 그냥 23으로 바로 변경
		// 2. 분 단위가 45분 이상일때 -> 시 단위 그대로 & 분 단위 = 현재분 - 45
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		int H = Integer.parseInt(st.nextToken()); // 시
		int M = Integer.parseInt(st.nextToken()); // 분 
		
		// 출력 String 선언
		StringBuilder sb = new StringBuilder();
		
		if (M < 45) {
			if (H == 0) {
				sb.append(23+" "); // 출력 시
				sb.append(60+M-45); // 출력 분
			} else {
				sb.append(H-1+" ");
				sb.append(60+M-45);
			}
		} else {
			sb.append(H+" ");
			sb.append(M-45);
		}
		
		System.out.println(sb);
	}
}