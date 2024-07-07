
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] inpArr, resArr;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// input은 배열에 저장해두고
		// for문 돌면서 오른쪽에 있는 수들 큐에 저장후 뱉으면서 지금 확인하는 수보다 큰지 확인
		
		// 시간초과..... 문제유형이 큐가 아니고 스택이네유 ?..
		// 뒤에서부터 판단?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		inpArr = new int[N];
		resArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			inpArr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(inpArr[N-1]);
		// 맨 뒤 결과는 무조건 -1
		resArr[N-1] = -1;
	
		// 뒤에서부터 확인
		// 확인하는 수보다 큰 수가 있는지 stack 확인 
		for (int i=N-2; i>=0; i--) {
			boolean flag = false;
			while (!stack.isEmpty()) {
				int tmp = stack.pop();
				if (tmp > inpArr[i]) {
					resArr[i] = tmp;
					// 다시 넣어두기
					stack.push(tmp);
					// 나도 넣어둬~
					stack.push(inpArr[i]);
					flag = true;
					break;
				}
			}
			if (!flag) {
				resArr[i] = -1;
				stack.push(inpArr[i]);
			}
		}
		
		for (int res : resArr) {
			sb.append(res+" ");
		}
		
		System.out.println(sb);
	}
}
