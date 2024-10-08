import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// 연두의 영어이름과 팀 이름 후보 N개에서 등장하는 알파벳 조합으로 우승 확률 계산
		
		// N개 만큼의 charArr 만들어서
		// 배열 별 확률 구하기
		// for문 -> L O V E cnt++
		// + 조건 : 동점인 경우 사전 앞서는 팀 이름 출력
		
		// Q. 연두의 이름을 꼭 더해야 하는지?
		// 팀 이름만 확인해도 될거 같은데~?
		// A. 써야합니다..... 연두 이름 안쓰면 확률이 0이 되는 경우도 있는듯ㅠ  
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연두 이름
		String ydName = br.readLine();
		// 연두 이름 charArr
		char[] ydNameArr = ydName.toCharArray();
		
		// 알파벳 카운트
		int lCnt = 0;
		int oCnt = 0;
		int vCnt = 0;
		int eCnt = 0;
		for (int i=0; i<ydNameArr.length; i++) {
			switch (ydNameArr[i]) {
				case 'L':
					lCnt++;
					break;
				case 'O':
					oCnt++;
					break;
				case 'V':
					vCnt++;
					break;
				case 'E':
					eCnt++;
					break;
			}
		}
		
		
		// 팀 이름 후보 개수
		int N = Integer.parseInt(br.readLine());
		
		// 팀 이름 넣어둘 배열 & 점수 넣어둘 배열 2개 만들기
		char[][] tNameArr = new char[N][]; // 각 요소는 charArr로 들어가도록
		int[] scoreArr = new int[N];
		
		// 팀 이름 배열 요소값 초기화
		for (int i=0; i<N; i++) {
			tNameArr[i] = br.readLine().toCharArray();
			
			// 안해주면...... count가 이상하게 초기화 된다 ㅠ ㅠ 
			int flCnt = lCnt;
			int foCnt = oCnt;
			int fvCnt = vCnt;
			int feCnt = eCnt;


			// 확률 계산
			for (int j=0; j<tNameArr[i].length; j++) {			
				// switch ㄱㄱ
				switch (tNameArr[i][j]) {
					case 'L':
						flCnt++;
						break;
					case 'O':
						foCnt++;
						break;
					case 'V':
						fvCnt++;
						break;
					case 'E':
						feCnt++;
						break;
				}
			}
			
			// mod : 나머지 연산 
			int score = ((flCnt+foCnt)*(flCnt+fvCnt)*(flCnt+feCnt)*(foCnt+fvCnt)*(foCnt+feCnt)*(fvCnt+feCnt))%100;
			
			scoreArr[i] = score;
		}
		
		
		
		// for문 돌면서 max, maxIdx 구하려 했는데......
		// 동점 어떻게 처리?
		// 점수 + 이름 합쳐서 정렬? -> 점수도 문자열 처리 되버리면 제대로 정렬 안됨 ㅠ
		// max 구하고 또 다시 돌면서 동점인 idx에 해당하는 팀 이름 maxNameArr에 저장하고 
		// Arrays.sort() 후 0번에 있는 팀 이름 출력! 
		int max = 0;
		for (int i=0; i<N; i++) {
			if (max < scoreArr[i]) {
				max = scoreArr[i];
			}
		}
		
		String[] maxNameArr = new String[N];
		
		// 확률 가장 높은 팀명들 배열에 저장 
		for (int i=0; i<N; i++) {
			if (max == scoreArr[i]) {
				// char로 나눠놨던 팀 이름 string으로 합치기
				String teamName = "";
				for (int j=0; j<tNameArr[i].length; j++) {
					teamName += tNameArr[i][j];
				}
				maxNameArr[i] = teamName;
			} else { // max 아닌경우 
				maxNameArr[i] = "null"; // 소문자 입력해서 제일 뒤로 가도록 처리 ㅠ
			}
		}
		
		
		// 알파벳순 정렬
		Arrays.sort(maxNameArr);
		// 여기서 배열에 null이 있는 경우 자꾸 오류가 났다 ㅠ 
		// max값이 아닌 경우 따로 처리 or 배열 길이 설정 다시?
	
		
		// 정답~?
		System.out.println(maxNameArr[0]);

	}

}