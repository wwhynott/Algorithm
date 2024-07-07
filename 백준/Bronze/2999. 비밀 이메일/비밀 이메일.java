
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// 문자열 길이에 루트씌워서 나온 수(int)만큼 띄워가면서 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		int len = input.length();
		int rlen = (int) Math.sqrt(len);

		int R = 0;
		int C = 0;
		for (int i=1; i<=rlen; i++) {
			if (len % i == 0) {
				R = i;
				C = len/i;
			}
		}
		
		for (int j = 0; j < R; j++) {
			int idx = 0;
			while (idx < len) {
				if (idx % R == j) {
					sb.append(input.charAt(idx));
				}
				idx++;
			}
		}

		System.out.println(sb);
		
		// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
		
		// 1 2 3 4 5 6 7
		// 8 9 10 11 12 13 14
		// 15 16 17 18 19 20 21
		
		// 1 8 15 2 9 16 3 10 17 4 11 18 ...
	}
}