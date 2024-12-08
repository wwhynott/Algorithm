import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		label:
		while (true) {
			String s = br.readLine();
			
			if (s.equals("0")) break;
			
			for (int i=0; i<=s.length()/2; i++) {
				char c1 = s.charAt(i);
				char c2 = s.charAt(s.length()-1-i);
				
				if (c1 != c2) {
					sb.append("no"+"\n");
					continue label;
				}
			}
			
			sb.append("yes"+"\n");
		}		
		
		System.out.println(sb);
	}
}
