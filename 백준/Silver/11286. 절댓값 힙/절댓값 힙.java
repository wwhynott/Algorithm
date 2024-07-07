
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 연산 개수
		int N = Integer.parseInt(br.readLine());
		
		int[] heap = new int[N+1]; // idx 1부터 사용
		int heapSize = 0;
		
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				sb.append(pop(heap, heapSize)+"\n");
				if (heapSize > 0) {
					heapSize--;
				}
			} else { // 0이 아닌 자연수라면 x 입력
				push(heap, heapSize, x);
				heapSize++;
			}
		}
		System.out.println(sb);

	}

	// 삽입
	static void push(int[] heap, int heapSize, int data) {
		// 마지막 노드(heapSize+1)에 원소 입력 후
		// 부모와 비교하면서 swap (항상 부모 >= 자식)
		heap[++heapSize] = data;

		// 내(자식) 위치, 부모 위치
		int ch = heapSize;
		int p = heapSize / 2;

		// 자식 절대값이 부모보다 작거나 같으면 & 비교할 부모가 루트 위로 가지 않게
		while (p > 0 && Math.abs(heap[p]) >= Math.abs(heap[ch])) {
			// 절대값이 같을때는 자식이 루트보다 작으면 swap
			if (Math.abs(heap[p]) == Math.abs(heap[ch])) {
				if (heap[p] > heap[ch]) {
					int tmp = heap[p];
					heap[p] = heap[ch];
					heap[ch] = tmp;
				}
			} else {
				int tmp = heap[p];
				heap[p] = heap[ch];
				heap[ch] = tmp;				
			}

			// 부모, 자식 인덱스 업데이트
			ch = p;
			p = ch / 2;
		}
	}

	// 삭제
	static int pop(int[] heap, int heapSize) {
		// 힙에 원소가 없다면 0 출력
		if (heapSize == 0) {
			return 0;
		}

		// 루트를 리턴한 후
		// 제일 마지막 노드를 루트로 가져온 다음
		// 자식과 비교하면서 swap (부모 >= 자식)
		// 이때 왼쪽, 오른쪽 자식 중 더 큰 자식과 swap 한다
		int root = heap[1];

		heap[1] = heap[heapSize--];

		// 내(부모) 위치, 자식 위치
		int p = 1;
		int ch = p * 2; // 왼쪽 자식

		// 왼/오 자식 비교
		// 오른쪽 자식이 size보다 작거나 같고 왼쪽보다 오른쪽 자식 절대값이 더 작다면
		if (ch + 1 <= heapSize && Math.abs(heap[ch]) >= Math.abs(heap[ch + 1])) {
			if (Math.abs(heap[ch]) == Math.abs(heap[ch+1])) {
				if (heap[ch] > heap[ch+1]) {
					ch++; // 비교할 자식 오른쪽으로 변경					
				}
			} else {
				ch++; // 비교할 자식 오른쪽으로 변경
			}
		}

		// 자식과 swap
		while (ch <= heapSize && Math.abs(heap[p]) >= Math.abs(heap[ch])) {
			if (Math.abs(heap[p]) == Math.abs(heap[ch])) {
				if (heap[p] > heap[ch]) {
					int tmp = heap[p];
					heap[p] = heap[ch];
					heap[ch] = tmp;
				}
			} else {
				int tmp = heap[p];
				heap[p] = heap[ch];
				heap[ch] = tmp;				
			}

			// 부모, 자식 인덱스 업데이트
			p = ch;
			ch = p * 2;

			if (ch + 1 <= heapSize && Math.abs(heap[ch]) >= Math.abs(heap[ch + 1])) {
				if (Math.abs(heap[ch]) == Math.abs(heap[ch+1])) {
					if (heap[ch] > heap[ch+1]) {
						ch++; // 비교할 자식 오른쪽으로 변경					
					}
				} else {
					ch++; // 비교할 자식 오른쪽으로 변경
				}
			}
		}

		return root;
	}
}
