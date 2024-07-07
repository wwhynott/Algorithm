import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 과목 개수
		int N = Integer.parseInt(br.readLine());
		// 점수 배열
		int[] scoreArr = new int[N];
		// 점수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			int score = Integer.parseInt(st.nextToken());
			scoreArr[i] = score;
		}
		
		// 점수 최대값 찾기
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			if (scoreArr[i] > max) {
				max = scoreArr[i];
			}
		}
		
		// 새로운 평균 구하기
		double totScore = 0;
		for (int i=0; i<N; i++) {
			double fakeScore = ((double)scoreArr[i]/max)*100;
			totScore += fakeScore;
		}
		
		System.out.println(totScore/N);
	}
}