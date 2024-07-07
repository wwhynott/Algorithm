import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		// 문자열을 char로 쪼개서 LinkedList에 넣기
		LinkedList<Character> editList = new LinkedList<>();
		for (int i=0; i<input.length(); i++) {
			editList.add(input.charAt(i));
		}
		
		// 명령어 개수
		int M = Integer.parseInt(br.readLine());
		
//		// 초기 커서 위치
//		int cursor = input.length();
		
		// 시간초과 해결 방법 -> listIterator 
		ListIterator<Character> iter = editList.listIterator();
		
		// 초기 커서위치 맨 뒤로 설정 
		while (iter.hasNext()) {
			iter.next();
		}
		
		// editor
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char command = st.nextToken().charAt(0);
			
			switch (command) {
				case 'L': {
					if (iter.hasPrevious()) {
						iter.previous();
					}
					break;
				}
				case 'D': {
					if (iter.hasNext()) {
						iter.next();
					}
					break;
				}
				case 'B': {
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				}
				case 'P': {
					char $ = st.nextToken().charAt(0);
					iter.add($);
					break;
				}
			}
		}
		
//		// 커서 맨 앞으로 이동 
//		while (iter.hasPrevious()) {
//			iter.previous();
//		}
//		
//		// 앞에서부터 읽기
//		while (iter.hasNext()) {
//			System.out.print(iter.next());
//		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Character x : editList) {
			sb.append(x);
		}
		
		System.out.println(sb);
		
	}
}
