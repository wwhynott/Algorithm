import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 최종 문장에서 적어도 한 마리의 앵무새는 자기가 가진 문장을 완벽히 말할 수 있음
		// -> 잘못 생각함......... 서로 번갈아가면서 말을 가로챌 수도 있다
		// 최종 문장의 각 단어를 큐에 저장하고
		// 각 앵무새 단어가 순서대로 입력되어 있는지 확인
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
			
		// 앵무새 문장 저장 배열
		Queue<String>[] arr = new Queue[N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new LinkedList<>();
			while (st.hasMoreTokens()) {
				arr[i].add(st.nextToken());				
			}
		}
		
		// 최종 문장
		Queue<String> Lqueue = new LinkedList<>();
		StringTokenizer L = new StringTokenizer(br.readLine());
        int lenL = L.countTokens();
		while (L.hasMoreTokens()) {
			Lqueue.add(L.nextToken());
		}
		
		for (int i=0; i<N*lenL; i++) {
			String sentence = Lqueue.peek(); // 최종 문장 맨 앞 단어
			for (int j=0; j<N; j++) {
				if (arr[j].isEmpty()) {
					continue;
				}
				if (arr[j].peek().equals(sentence)) {
					arr[j].poll();
					Lqueue.poll();
					break;
				}
			}
			
			if (Lqueue.isEmpty()) {
				break;
			}
		}
		
        flag:
		if (Lqueue.isEmpty()) {
			for (int i=0; i<N; i++) {
				if (!arr[i].isEmpty()) {
					System.out.println("Impossible");
                    break flag;
				}
			}
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
		
	
	}
}
