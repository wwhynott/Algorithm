
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int pCnt;
	static Candidate[] pArr;
	static int intvCut;
	static int res;
	
	static class Candidate implements Comparable<Candidate>{
		int doc, intv;

		public Candidate(int doc, int intv) {
			this.doc = doc;
			this.intv = intv;
		}

		@Override
		public int compareTo(Candidate o) {
			return this.doc - o.doc;
		}	
	}
	
	public static void main(String[] args) throws Exception {
		
		// 일단 서류 기준으로 정렬하고 면접 점수 커트라인 업데이트해가면서 선발
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			pCnt = Integer.parseInt(br.readLine());
			pArr = new Candidate[pCnt];
			intvCut = 0;
			res = 1; // 1등은 일단 뽑을거니까~
			
			for (int c=0; c<pCnt; c++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int d = Integer.parseInt(st.nextToken());
				int i = Integer.parseInt(st.nextToken());
				
				pArr[c] = new Candidate(d, i);
				
				if (d == 1) {
					intvCut = i;
				}
			}
			
			Arrays.sort(pArr);
			
			for (int i=1; i<pCnt; i++) {
				if (pArr[i].intv < intvCut) {
					res++;
					intvCut = pArr[i].intv; // 면접 컷 업데이트
				}
			}
			
			sb.append(res+"\n");
		}
		System.out.println(sb);			
	}
}
