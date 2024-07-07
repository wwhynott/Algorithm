
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] heap;
	static int heapSize;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		heap = new int[N+1];
		heapSize = 0;
		
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				sb.append(pop()+"\n");
			} else {
				push(x);
			}
		}
		
		System.out.println(sb);
	}
	
	static void push(int x) {
		// 리프노드에 입력
		// 부모와 비교하면서 부모보다 작다면 자리 교체
		heap[++heapSize] = x;
		
		int p = heapSize/2;
		int c = heapSize;
		
		while (p > 0 && heap[c] < heap[p]) {
			int tmp = heap[c];
			heap[c] = heap[p];
			heap[p] = tmp;
			
			c = p;
			p = c/2;
		}
	}
	
	static int pop() {
		// 부모노드값 출력
		// 마지막 노드 루트로 가져온 후 힙 재정렬
		// 자식 중 더 작은 자식과 교환
		if (heapSize == 0) {
			return 0;
		}
		
		int root = heap[1];
		heap[1] = heap[heapSize--];
		
		int p = 1;
		int c = p*2;
		
		if (c+1 <= heapSize && heap[c] > heap[c+1]) {
			c++;
		}
		
		while (c <= heapSize && heap[c] < heap[p]) {
			int tmp = heap[c];
			heap[c] = heap[p];
			heap[p] = tmp;
			
			p = c;
			c = p*2;
			
			if (c+1 <= heapSize && heap[c] > heap[c+1]) {
				c++;
			}	
		}
		
		return root;
	}
}
