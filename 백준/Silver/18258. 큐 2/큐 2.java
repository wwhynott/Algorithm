import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 명령의 수 입력
		
		// 사용할 queue 선언
		Queue<String> res = new LinkedList<>();
		
		// 출력 String 선언
		StringBuilder sb = new StringBuilder();
        
        // back에서 사용할 마지막 값 .....
		String last = "";
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String c = st.nextToken(); // case 받기 
			
			switch (c) {
				case "push": // 입력할 정수 X 받기
					String X = st.nextToken();
					res.offer(X);
                    last = X; // 넣을 때 마다 last값 업데이트
					break;
				case "pop":
					if (res.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(res.poll()+"\n"); 
					}
					break;
				case "size":
					sb.append(res.size()+"\n");
					break;
				case "empty":
					if (res.isEmpty()) {
						sb.append(1+"\n");
					} else {
						sb.append(0+"\n");
					}
					break;
				case "front":
					if (res.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(res.peek()+"\n");
					}
					break;
				case "back":
					if (res.isEmpty()) {
						sb.append(-1+"\n");
					} else { // last값 출력
						sb.append(last+"\n");
					}
                    break;
			}
		}
		System.out.println(sb);
	}
}