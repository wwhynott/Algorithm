import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 첫번째 줄에서 queue 또는 stack의 개수 확인 (N)
		// 두번째 줄에서 각 자료구조 queue인지 stack인지 확인
		// 세번째 줄은 각 자료구조에 이미 들어가 있는 원소
		// 네번째 줄은 삽입할 수열 길이 (M)
		// 다섯번째 줄은 삽일할 수열 (M개의 원소)

		// + stack인 경우는 고려할 필요가 없다
		// => queue일때만 덱에 넣어서 ㄱㄱ

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 자료구조 개수
		int N = Integer.parseInt(br.readLine());

		// 출력 스트링
		StringBuilder sb = new StringBuilder();
		
		// 덱
		Deque<Integer> deque = new ArrayDeque<>();

		// 자료구조 type
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		// 각 자료구조 초기 요소
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int type = Integer.parseInt(st1.nextToken());
			int element = Integer.parseInt(st2.nextToken());
			if (type == 0) { // queue인 경우만 고려
				deque.offer(element);
			}
		}
		
		// 입력값을 덱의 맨 앞에 넣고, 맨 뒤 값 출력 !!!
		
		// M번 돌면서 원소 입력
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st3 = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(st3.nextToken());
			deque.offerFirst(input);
			int pop = deque.pollLast();
			
			// 최종 pop 출력
			sb.append(pop + " ");
		}
		System.out.println(sb);
	}
}