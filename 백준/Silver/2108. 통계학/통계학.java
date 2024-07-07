
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {	
	
	// 입력받은 수 저장 큐
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	// 큐 왔다갔다하면서 값 확인
	static PriorityQueue<Integer> pq2 = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		// 네가지 산수 프로그램을 만들자!
		// 정렬한 후 계산하면 좋은 경우가 많으니까 pq 사용하자
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받는 수의 개수 
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		System.out.println(arithmeticMean());
		System.out.println(getMedian());
		System.out.println(getMode());
		System.out.println(getRange());
	}
	
	// 산술평균
	static int arithmeticMean() {
		int qSize = pq.size(); // 큐 초기 사이즈 저장
		double sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.peek();
			pq2.add(pq.poll());
		}
		double am = sum/qSize;
		
		return (int) Math.round(am);
	}
	
	// 중앙값 
	static int getMedian() {
		int medIdx = pq2.size()/2;
		for (int i=0; i<medIdx; i++) {
			pq.add(pq2.poll());
		}
		int Median = pq2.peek();
		while (!pq2.isEmpty()) {
			pq.add(pq2.poll());
		}
		return Median;
	}
	
	// 최빈값
	static int getMode() {
		// 카운트 배열?... ㅠ
		int[] posCntArr = new int[4001]; // 양수 카운트 배열 (0포함)
		int[] negCntArr = new int[4001]; // 음수 카운트 배열
		while (!pq.isEmpty()) {
			if (pq.peek() < 0) { // 음수이면
				negCntArr[Math.abs(pq.peek())]++;
				pq2.add(pq.poll());
			} else { // 양수이면
				posCntArr[pq.peek()]++;
				pq2.add(pq.poll());
			}
		}
		// 일단 최대 cnt 개수를 구하고
		// 그 cnt 개수를 가진 수들 뽑고
		// 만약 여러개라면 두번째 작은 값 출력
		// 이것도 pq 사용?
		int max = 0;
		for (int i=0; i<4001; i++) {
			int tmp = Math.max(posCntArr[i], negCntArr[i]);
			if (max < tmp) {
				max = tmp;
			}
		}
		
		PriorityQueue<Integer> pqCnt = new PriorityQueue<>();
		
		for (int i=0; i<4001; i++) {
			if (posCntArr[i] == max) {
				pqCnt.add(i);
			}
			if (negCntArr[i] == max) {
				pqCnt.add(-i);
			}
		}
		
		// 최빈값이 여러개인 경우 두번째로 작은값 출력
		if (pqCnt.size() >= 2) {
			pqCnt.poll(); // 하나 버리고
			return pqCnt.poll(); // 두번째 작은값 출
		} else {
			return pqCnt.poll();
		}
		
		
	}
	
	// 범위
	static int getRange() {
		if (pq2.size() == 1) {
			return 0;
		}
		
		int min = pq2.poll();
		while (pq2.size() != 1) {
			pq2.poll();
		}
		int max = pq2.poll();
		
		return max - min;
	}
}
