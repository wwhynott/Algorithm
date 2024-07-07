
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// S랑 T 길이 차 구해서 연산 횟수 구하고
		// dfs 고?.. -> 시간초과~ 
		
		// T를 가지고 S를 만들자
		// T의 맨뒤가 A -> A 빼기
		// 			B -> B 빼고 단어 뒤집기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		// T 길이가 S 길이만큼 될때까지 반복
		while( S.length() != T.length() ) {
			// T의 마지막 알파벳 확인
			if (T.endsWith("A")) {
				T = T.substring(0, T.length()-1);
				continue;
			}
			if (T.endsWith("B")) {
				T = T.substring(0, T.length()-1);
				StringBuffer sb = new StringBuffer(T);
				T = sb.reverse().toString();
				continue;
			}
		}
		
		if (S.equals(T)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
