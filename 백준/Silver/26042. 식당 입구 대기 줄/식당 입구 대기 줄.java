import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 대기중인 학생 수 최대일때 학생 수 & 맨 뒤 학생번호
		// 최대일 때가 여러 경우라면, 맨 뒤 학생번호가 가장 작은 경우 출력
		// 매 정보 별 큐 길이 & 그 때 맨 뒤에있는 학생번호 저장
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수 입력
		
		// 사용할 큐 선언
		Queue<Integer> queue = new LinkedList<>();
		
		// 큐 길이 저장 배열
		int[] qsizeArr = new int[N];
		// 학생번호 저장 배열
		int[] sNumArr = new int[N];
		
		// 맨 뒤에 선 학생번호 저장 변수
		int sNum = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int c = Integer.parseInt(st.nextToken()); // case 받기
			if (c == 1) {
				// 학생번호 a인 학생이 맨 뒤에 줄을 선다 
				int a = Integer.parseInt(st.nextToken());
				queue.offer(a);
				sNum = a;
			} else { // c == 2
				// 맨 앞 학생 1명이 식사를 시작한다
				queue.poll();
			}
			
			// 큐 길이 & 학생번호 저장
			qsizeArr[i] = queue.size();
			sNumArr[i] = sNum;
		}
		
		// 큐 길이 최대값 찾기
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (qsizeArr[i] > max) {
				max = qsizeArr[i];
			}
		}
		
		// 최대값인 경우 여러개라면.... 그 학생번호들 뽑기...
		List<Integer> maxSNum = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (qsizeArr[i] == max) {
				maxSNum.add(sNumArr[i]);
			}
		}
		
		// 리스트에 저장된 학생 번호 중 최소값 구하기 -> 오름차순 정렬
		Collections.sort(maxSNum);	

		System.out.println(max+" "+maxSNum.get(0));
	}
}