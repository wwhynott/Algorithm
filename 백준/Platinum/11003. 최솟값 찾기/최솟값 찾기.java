
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L;
	static Deque<Node> deque;
	
	static class Node {
		int num;
		int idx;
		
		Node(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 확인하는 인덱스 요소와 앞쪽 L-1개 요소 중 최소값 찾기
		// pq에 L개 입력하고 맨 앞 요소 poll
		// 당~연히 시간초과~ (3%)
		
		// 슬라이딩 윈도우
		// L개의 요소까지는 위 방식으로 확인하고
		// 그 이후부터는 제외될 요소 제외하고 지금 인덱스 추가해서 확인~?
		// 응 시간초과 (10%)
		
		// 덱 사용하기
		// 덱의 맨 앞에 항상 최소값이 오도록 처리 && 인덱스 만족하는지도 확인
		// 참고 : https://velog.io/@dawonseo/Java%EB%B0%B1%EC%A4%80-11003-%EC%B5%9C%EC%86%9F%EA%B0%92-%EC%B0%BE%EA%B8%B0
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		deque = new ArrayDeque<>();
		for (int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			// 먼저 들어간 값들이 지금 넣으려는 값보다 작지 않으면 그 값들은 필요없는 값이다 ~
			// -> 덱의 맨 끝 값이 현재값보다 크면 끝 값 삭제
			while (!deque.isEmpty() && deque.getLast().num > input) {
				deque.removeLast();
			}
			
			deque.add(new Node(input, i));
			
			// 덱의 맨 앞쪽 값 idx가 지금 확인해야하는 범위(i-L)를 벗어났다면 삭제
			while (!deque.isEmpty() && deque.getFirst().idx <= i - L) {
				deque.removeFirst();
			}
			
			// 덱의 맨 앞이 지금 범위의 최소값
			sb.append(deque.getFirst().num).append(" ");
		}

		System.out.println(sb);
	}
}
